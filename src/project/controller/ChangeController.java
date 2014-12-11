package project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import project.model.Change;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.Time;
import java.util.Date;

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
    @FXML
    private TableColumn<Change, Integer> rowColumn;
    @FXML
    private TableColumn<Change, Integer> seatColumn;
    @FXML
    private TableColumn<Change, Integer> theaterColumn;
    @FXML
    private TableColumn<Change, Date> dateColumn;
    @FXML
    private TableColumn<Change, Time> timeColumn;


    public ChangeController() {
    //empty constructor
    }

    @FXML
    public void initialize() {



    }


    @FXML
    /*
    search button; search for a reservation with a phonenumber
     */
    public void searchButtonHandler(ActionEvent event) {
        System.out.println("search button clicked");

    }


    @FXML
    /*
    delete button; delete a specific reservation
     */
    public void deleteButtonHandler() {
        System.out.println("delete button clicked");
    }

    @FXML
    /*
    change button; change a specific reservation.
     */
    public void changeButtonHandler() {
        System.out.println("change button clicked");
    }
}
