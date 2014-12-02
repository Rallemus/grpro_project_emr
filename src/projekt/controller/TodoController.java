package projekt.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import projekt.model.Todo;
import java.time.LocalDate;
import java.util.Observable;

/**
 * Created by Rasmus on 01-12-2014.
 */
public class TodoController {

    @FXML
    private TableView<Todo> todoTable;
    @FXML
    private TableColumn<Todo, String> taskColumn;
    @FXML
    private TableColumn<Todo, String> projectColumn;
    @FXML
    private TableColumn<Todo, LocalDate> dueDateColumn;

    public TodoController() {
        /**/

    }

    @FXML
    private void initialize() {
        taskColumn.setCellValueFactory(
            cellData -> cellData.getValue().taskProperty()
        );

        projectColumn.setCellValueFactory(
            cellData -> cellData.getValue().projectProperty()
        );

        dueDateColumn.setCellValueFactory( cellData ->
            cellData.getValue().dueDateProperty()
        );

        dueDateColumn.setCellFactory( column -> {
            return new TableCell<Todo, LocalDate>() {
                @Override
                protected void updateItem(LocalDate dueDate, boolean empty) {
                    super.updateItem(dueDate, empty);

                    if(dueDate == null || empty) {
                        setText(null);
                    } else {
                        setText(Todo.DueDateFormatter.format(dueDate));

                    }
                }
            };
        });

        todoTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    System.out.println("Selected: " + newValue.getTask());
                }
        );
    }

    public void newButtonHandler() {
        System.out.println("new button clicked");
    }

    public void setData(ObservableList<Todo> data) {
        todoTable.setItems(data);
    }
}
