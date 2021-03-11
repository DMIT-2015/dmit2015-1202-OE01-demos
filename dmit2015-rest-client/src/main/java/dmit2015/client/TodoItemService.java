package dmit2015.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import java.util.List;


/**
 * The baseUri for the web service be set in either microprofile-config.properties (recommended)
 * or in this file using @RegisterRestClient(baseUri = "http://server/path").
 *
 * To set the baseUri in microprofile-config.properties:
 *    1) Open src/main/resources/META-INF/microprofile-config.properties
 *    2) Add a key/value pair in the following format:
 *          package-name.ClassName/mp-rest/url=baseUri
 *       For example:
 *          package-name:    dmit2015.client
 *          ClassName:       TodoItemMicroprofileService
 *          baseUri:         http://localhost:8080/dmit2015-server-demo
 *       The key/value pair you need to add is:
 *          dmit2015.model.TodoItemService/mp-rest/url=http://localhost:8080/dmit2015-intructor-jaxrs-demo/webapi
 *
 *
 * To use the client interface from an environment does support CDI, add @Inject and @RestClient before the field declaration such as:
 *
 *     @Inject
 *     @RestClient
 *     private TodoItemMicroprofileService _todoItemService;
 *
 * To use the client interface from an environment that does not support CDI, you can use the RestClientBuilder class to programmatically build an instance as follows:
 *
 *      URI apiURi = new URI("http://sever/path");
 *      TodoItemMicroprofileService _todoItemService = RestClientBuilder.newBuilder()
 *                 .baseUri(apiURi)
 *                 .build(TodoItemMicroprofileService.class);
 *
 */
@RegisterRestClient //(baseUri = "http://localhost:8080/dmit2015-instructor-jaxrs-demo/webapi")
@Path("TodoItems")
public interface TodoItemService {

    @GET
    List<TodoItem> findAllTodoItem();

    @GET
    @Path("{todoItemId}")   // {replaceableParameter}
    TodoItem findOneById(@PathParam("todoItemId") Long id);

    @POST
    String createTodoItem(TodoItem newTodoItem);

    @PUT
    @Path("{todoItemId}")
    void updateTodoItem(@PathParam("todoItemId") Long id, TodoItem updatedTodoItem);

    @DELETE
    @Path("{todoItemId}")
    void deleteTodoItem(@PathParam("todoItemId") Long id);

}
