package project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.controller.TodoController;
import project.model.Todo;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by Rasmus on 01-12-2014.
 */
public class Main extends Application {

    private ObservableList<Todo> todoData = FXCollections.observableArrayList();


    public Main() {
        todoData.add(new Todo("program javafx APP", "programmering", LocalDate.of(2014, 10, 22)));
        todoData.add(new Todo("clean the bathroom", "programmering", LocalDate.of(2014,10,29)));
        todoData.add(new Todo("hand in project", "programmering", LocalDate.of(2014,11,1)));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        showTodoView(primaryStage);
    }

    public void showTodoView(Stage stage) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/todo.fxml"));
            Parent toDoView = loader.load();
            stage.setTitle("Todo");
            stage.setScene(new Scene(toDoView, 300, 275));

            TodoController controller = loader.getController();
            controller.setData(todoData);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
