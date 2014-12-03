package project.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import project.model.Change;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Elise on 03-12-2014.
 */
public class ChangeController {
    @FXML
    private TableView<Change> changeTable;
    @FXML
    private TableColumn<Change, String> nameColumn;
    @FXML
    private TableColumn<Change, String> phoneColumn;
    @FXML
    private TableColumn<Change, String> showsColumn;

    public ChangeController() {

    }

}
