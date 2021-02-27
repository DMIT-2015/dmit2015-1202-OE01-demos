package dmit2015.client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TodoItemConsoleApp {

    private void findAllTodoItem(TodoItemRetrofitClient webClient) {
        Call<List<TodoItem>> callFindAll = webClient.findAll();

        try {
            Response<List<TodoItem>> response = callFindAll.execute();
            if (response.isSuccessful()) {
                List<TodoItem> todoItems = response.body();
                //todoItems.forEach(System.out::println);
                todoItems.forEach(singleItem -> {
                    System.out.println("Id: " + singleItem.getId());
                    System.out.println("Name: " + singleItem.getName());
                    System.out.println("Complete: " + singleItem.isComplete());
                    System.out.println("");
                });
            }
        } catch (IOException e) {
            System.out.println("Fail to communicate with server");
//            e.printStackTrace();
        }
    }

    private void findOneTodoItem(TodoItemRetrofitClient webClient, Long todoItemId) {
        Call<TodoItem> callFindOne = webClient.findOneById(todoItemId);
        try {
            Response<TodoItem> response = callFindOne.execute();
            if (response.isSuccessful()) {
                TodoItem singleTodoItem = response.body();
                System.out.println("Successfully found the following object:");
                System.out.println(singleTodoItem);
            }
        } catch (Exception e) {
            System.out.println("Fail to communicate with server in findOneTodoItem");
        }
    }

    private void createTodoItem(TodoItemRetrofitClient webClient, String name) {
        TodoItem newTodoItem = new TodoItem();
        newTodoItem.setName(name);
        Call<ResponseBody> callCreate = webClient.create(newTodoItem);
        try {
            Response<ResponseBody> response = callCreate.execute();
            if (response.isSuccessful()) {
                String resourceLocation = response.headers().get("location");
                System.out.println("Successfully created resource at " + resourceLocation);
            } else {
                System.out.println("Request not successful with code: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Fail to communicate with server in createTodoItem method.");
        }
    }

    private void updateTodoItem(TodoItemRetrofitClient webClient, TodoItem updatedTodoItem) {
        Call<ResponseBody> callUpdate = webClient.update(updatedTodoItem.getId(), updatedTodoItem);
        try {
            Response<ResponseBody> response = callUpdate.execute();
            if (response.isSuccessful()) {
                System.out.println("Successfully updated TodoItem.");
            } else {
                System.out.println("Request was not successful with code: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Fail with communicate with server in updateTodoItem method.");
        }
    }

    private void deleteTodoItem(TodoItemRetrofitClient webClient, Long todoItemId) {
        Call<ResponseBody> callDelete = webClient.delete(todoItemId);
        try {
            Response<ResponseBody> response = callDelete.execute();
            if (response.isSuccessful()) {
                System.out.println("Successfully deleted TodoItem.");
            } else {
                System.out.println("Request was not successful with code: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Fail with communicate with server in deleteTodoItem method.");
        }
    }

    public void run() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/dmit2015-instructor-jaxrs-demo/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        TodoItemRetrofitClient webClient = retrofit.create(TodoItemRetrofitClient.class);

        int menuChoice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("TodoItem Web Client");
            System.out.println("-------------------");
            System.out.println("1. List all TodoItem");
            System.out.println("2. Find one TodoItem");
            System.out.println("3. Create a TodoItem");
            System.out.println("4. Update a TodoItem");
            System.out.println("5. Delete a TodoItem");
            System.out.println("0. Exit program");
            System.out.println("Your choice >>> ");
            menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1: {
                    findAllTodoItem(webClient);
                }
                break;
                case 2: {
                    System.out.println("Enter the id of the TodoItem to search for: ");
                    Long todoItemId = scanner.nextLong();
                    findOneTodoItem(webClient, todoItemId);
                }
                break;
                case 3: {
                    System.out.println("Enter the name of the TodoItem: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    createTodoItem(webClient, name);
                }
                break;
                case 4: {
                    System.out.println("Enter the id of the TodoItem to update: ");
                    Long todoItemId = scanner.nextLong();
                    System.out.println("Enter the new name of the TodoItem: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                }
                break;
                case 5: {
                    System.out.println("Enter the id of the TodoItem to delete: ");
                    Long todoItemId = scanner.nextLong();
                    deleteTodoItem(webClient, todoItemId);
                }
                break;
                case 0: {
                    System.out.println("Good-bye");
                }
                default:
                    System.out.println("Invalid menu choice. Try again.");
                    break;
            }
        } while (menuChoice != 0);
    }


    public static void main(String[] args) {
        TodoItemConsoleApp app = new TodoItemConsoleApp();
        app.run();

//        callFindAll.enqueue(new Callback<List<TodoItem>>() {
//            @Override
//            public void onResponse(Call<List<TodoItem>> call, Response<List<TodoItem>> response) {
//                if (response.isSuccessful()) {
//                    List<TodoItem> todoItems = response.body();
//                    //todoItems.forEach(System.out::println);
//                    todoItems.forEach(singleItem -> {
//                        System.out.println("Id: " + singleItem.getId());
//                        System.out.println("Name: " + singleItem.getName());
//                        System.out.println("Complete: " + singleItem.isComplete());
//                        System.out.println("");
//                    });
//                } else {
//                    System.out.println("Response not successful with code: " + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<TodoItem>> call, Throwable throwable) {
//                System.out.println("Fail to communicate with server");
//            }
//        });

    }
}
