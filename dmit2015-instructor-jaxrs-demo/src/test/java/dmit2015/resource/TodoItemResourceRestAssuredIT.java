package dmit2015.resource;

import dmit2015.entity.TodoItem;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

/**
 * https://github.com/rest-assured/rest-assured
 * https://github.com/rest-assured/rest-assured/wiki/Usage
 * http://www.mastertheboss.com/jboss-frameworks/resteasy/restassured-tutorial
 * http://json-b.net/docs/user-guide.html
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TodoItemResourceRestAssuredIT {

    String testDataResourceLocation;

//    @BeforeAll
//    void beforeAll() {
//        // Skip SSL certificate validation
//        RestAssured.useRelaxedHTTPSValidation();
//    }

    @Order(1)
    @Test
    void shouldListAll() {
        given()
                .when()
                .get("/dmit2015-instructor-jaxrs-demo/webapi/TodoItems")
                .then()
                .statusCode(200)
                .body("$.size()", is(4),
                        "[0].id", is(1),
                        "[0].name", is("Wash face"),
                        "[0].complete", is(false),
                        "[3].id", is(4),
                        "[3].name", is("Go to work"),
                        "[3].complete", is(false)
                );
    }

    @Order(5)
    @Test
    void shouldListAllObjects() {
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get("/dmit2015-instructor-jaxrs-demo/webapi/TodoItems")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response();
        String jsonBody = response.getBody().asString();

        // Create a new Jsonb instance using the default JsonbBuilder implementation
        Jsonb jsonb = JsonbBuilder.create();
        List<TodoItem> todos = jsonb.fromJson(jsonBody, new ArrayList<TodoItem>(){}.getClass().getGenericSuperclass());
        assertEquals(5, todos.size());
        TodoItem firstTodoItem = todos.get(0);
        assertEquals("Wash face", firstTodoItem.getName());
        assertFalse(firstTodoItem.isComplete());

        TodoItem lastTodoItem = todos.get(todos.size() - 1);
        assertEquals("Updated Name", lastTodoItem.getName());
        assertTrue(lastTodoItem.isComplete());

        todos.forEach(System.out::println);
    }

    @Order(2)
    @Test
    void shouldCreate() {
        TodoItem newTodoItem = new TodoItem();
        newTodoItem.setName("Run JAX-RS Docker Integration Test");
        newTodoItem.setComplete(false);

        // Create a new Jsonb instance using the default JsonbBuilder implementation
        Jsonb jsonb = JsonbBuilder.create();
        String jsonBody = jsonb.toJson(newTodoItem);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("/dmit2015-instructor-jaxrs-demo/webapi/TodoItems")
                .then()
                .statusCode(201)
                .extract()
                .response();
        testDataResourceLocation = response.getHeader("location");
    }

    @Order(3)
    @Test
    void shouldFineOne() {
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get(testDataResourceLocation)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response();
        String jsonBody = response.getBody().asString();
        // Create a new Jsonb instance using the default JsonbBuilder implementation
        Jsonb jsonb = JsonbBuilder.create();
        TodoItem existingTodoItem = jsonb.fromJson(jsonBody, TodoItem.class);
        assertNotNull(existingTodoItem);
        assertEquals("Run JAX-RS Docker Integration Test", existingTodoItem.getName());
        assertFalse(existingTodoItem.isComplete());
    }

    @Order(4)
    @Test
    void shouldUpdate() {
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get(testDataResourceLocation)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response();
        String jsonBody = response.getBody().asString();
        // http://json-b.net/docs/user-guide.html
        // Create a new Jsonb instance using the default JsonbBuilder implementation
        Jsonb jsonb = JsonbBuilder.create();
        TodoItem existingTodoItem = jsonb.fromJson(jsonBody, TodoItem.class);
        assertNotNull(existingTodoItem);
        existingTodoItem.setName("Updated Name");
        existingTodoItem.setComplete(true);

        String jsonRequestBody = jsonb.toJson(existingTodoItem);
        given()
                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when()
                .put(testDataResourceLocation)
                .then()
                .statusCode(204);
    }

    @Order(6)
    @Test
    void shouldDelete() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete(testDataResourceLocation)
                .then()
                .statusCode(204);
    }
}

