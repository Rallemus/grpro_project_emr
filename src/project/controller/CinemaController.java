package project.controller;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import project.model.Cinema;
import javafx.beans.value.ChangeListener;

import javafx.fxml.FXML;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Maria on 02-12-2014.
 */
public class CinemaController {

    @FXML
    private ComboBox<String> boxShows;
    @FXML
    private ComboBox<Date> boxDate;
    @FXML
    private ComboBox<Time> boxTime;
    @FXML
    private Button clearBoxes;
    @FXML
    private Button reservationButton;

    public CinemaController() {
    }

    /**
     * This method fills out the choicebox made in JavaFX with data from the database by creating a new Cinema
     * object, and calling its getShow method which is responsible for accessing data from the database.
     */
    @FXML
    public void initialize() {
        reservationButton.setVisible(false); //sets the reservation-button to invisible, as it should not be possible
        //to make a reservation before all 3 parameters (title, date and time)
        //have been selected, as this is needed for a reservation.

        boxShows.setItems(new Cinema().getShow("", "")); //fills a combobox with all available shows (titles)
        boxDate.setItems(new Cinema().getDate("", "")); //fills a combobox with all available dates for shows
        boxTime.setItems(new Cinema().getTime("", "")); //fills a combobox with all available times for shows

        setActionForShowBox();

        setActionForDateBox();

        setActionForTimeBox();

        setActionForClearBoxes();

        //Event-handler for the reservation button which prints out a statement
        reservationButton.setOnAction((event) -> {
            System.out.println("Du har trykket reserver. Tillykke med det");
        });

    }


    private void setActionForShowBox() {
        //An event-handler for the combobox displaying show titles which is activated when a title is selected, which
        //the first if-statement takes care of.
        boxShows.setOnAction((event) -> {
            if (!boxShows.getSelectionModel().isEmpty()) { //only execute this code if a title has actually been selected
                String showtitle = boxShows.getSelectionModel().getSelectedItem().toString();
                String titletofreeze = boxShows.getSelectionModel().getSelectedItem();
                ObservableList<String> titletofreezelist = FXCollections.observableArrayList();
                titletofreezelist.add(titletofreeze);//adds the selected title to an ObservableList, which is neccesary
                // because this is the value needed to set the items in a combobox.
                boxShows.itemsProperty().set(titletofreezelist);
        //        boxShows.setItems(titletofreezelist);//makes sure that once you select an item, it is no longer possible
                //to change this value. This makes sure that you, after selecting
                //a date and a time, can't choose a title that doesn't match
                //the selected date and time.
                System.out.println(boxShows.getSelectionModel().getSelectedItem());
                //Execute only if the comboboxes containing dates and times are empty
                if (boxDate.getSelectionModel().isEmpty() && boxTime.getSelectionModel().isEmpty()) {
                    //a parameter to send as parameter to the model-class, which is used to get specific dates and times
                    //matching the given title.
                    boxDate.setItems(new Cinema().getDate(showtitle, ""));//set dates matching the title
                    boxTime.setItems(new Cinema().getTime("", showtitle));//set times matching the title
                } else if (!boxDate.getSelectionModel().isEmpty() && boxTime.getSelectionModel().isEmpty()) {
                    String showdate = boxDate.getSelectionModel().getSelectedItem().toString();
                    boxTime.setItems(new Cinema().getTime(showdate, showtitle));
                } else if (boxDate.getSelectionModel().isEmpty() && !boxTime.getSelectionModel().isEmpty()) {
                    String showtime = boxTime.getSelectionModel().getSelectedItem().toString();
                    boxDate.setItems(new Cinema().getDate(showtitle, showtime));
                }
                //Sets the reservation button to visible as all three parameters needed for this action has been selected
                if (!boxShows.getSelectionModel().isEmpty() && !boxDate.getSelectionModel().isEmpty() && !boxTime.getSelectionModel().isEmpty()) {
                    reservationButton.setVisible(true);
                }
            }
        });
    }

    private void setActionForDateBox() {
        boxDate.setOnAction((event) -> {
            if (!boxDate.getSelectionModel().isEmpty()) {
                String showdate = boxDate.getSelectionModel().getSelectedItem().toString();
                Date datetofreeze = boxDate.getSelectionModel().getSelectedItem();
                ObservableList<Date> datetofreezelist = FXCollections.observableArrayList();
                datetofreezelist.add(datetofreeze);
                boxDate.itemsProperty().set(datetofreezelist);
                System.out.println(boxDate.getSelectionModel().getSelectedItem());

                if (boxShows.getSelectionModel().isEmpty() && boxTime.getSelectionModel().isEmpty()) {
                    boxShows.setItems(new Cinema().getShow(showdate, ""));
                    boxTime.setItems(new Cinema().getTime(showdate, ""));
                } else if (!boxShows.getSelectionModel().isEmpty() && boxTime.getSelectionModel().isEmpty()) {
                    String showtitle = boxShows.getSelectionModel().getSelectedItem().toString();
                    boxTime.setItems(new Cinema().getTime(showdate, showtitle));
                } else if (boxShows.getSelectionModel().isEmpty() && !boxTime.getSelectionModel().isEmpty()) {
                    String showtime = boxTime.getSelectionModel().getSelectedItem().toString();
                    boxShows.setItems(new Cinema().getShow(showdate, showtime));
                }
                if (!boxShows.getSelectionModel().isEmpty() && !boxDate.getSelectionModel().isEmpty() && !boxTime.getSelectionModel().isEmpty()) {
                    reservationButton.setVisible(true);
                }
            }
        });
    }

    private void setActionForTimeBox() {
        boxTime.setOnAction((event) -> {
            if (!boxTime.getSelectionModel().isEmpty()) {
                String showtime = boxTime.getSelectionModel().getSelectedItem().toString();
                Time timetofreeze = boxTime.getSelectionModel().getSelectedItem();
                ObservableList<Time> timetofreezelist = FXCollections.observableArrayList();
                timetofreezelist.add(timetofreeze);
                boxTime.itemsProperty().set(timetofreezelist);
                System.out.println(boxTime.getSelectionModel().getSelectedItem());

                if (boxDate.getSelectionModel().isEmpty() && boxShows.getSelectionModel().isEmpty()) {
                    boxDate.setItems(new Cinema().getDate("", showtime));
                    boxShows.setItems(new Cinema().getShow("", showtime));
                } else if (!boxDate.getSelectionModel().isEmpty() && boxShows.getSelectionModel().isEmpty()) {
                    String showdate = boxDate.getSelectionModel().getSelectedItem().toString();
                    boxShows.setItems(new Cinema().getShow(showdate, showtime));
                } else if (boxDate.getSelectionModel().isEmpty() && !boxShows.getSelectionModel().isEmpty()) {
                    String showtitle = boxShows.getSelectionModel().getSelectedItem().toString();
                    boxDate.setItems(new Cinema().getDate(showtitle, showtime));
                }
                if (!boxShows.getSelectionModel().isEmpty() && !boxDate.getSelectionModel().isEmpty() && !boxTime.getSelectionModel().isEmpty()) {
                    reservationButton.setVisible(true);
                }
            }
        });
    }

    private void setActionForClearBoxes() {
        clearBoxes.setOnAction((event) -> {
            boxShows.getSelectionModel().clearSelection();//Clears the combobox
            boxShows.setItems(new Cinema().getShow("", ""));//Fills the combobox with it's original
            reservationButton.setVisible(false);//As the box is now unselected, it is no longer possible to make a reservation
            boxShows.setPromptText("Forestilling");

            boxDate.getSelectionModel().clearSelection();
            boxDate.setItems(new Cinema().getDate("", ""));
            reservationButton.setVisible(false);
            boxDate.setPromptText("Dato");

            boxTime.getSelectionModel().clearSelection();
            boxTime.setItems(new Cinema().getTime("", ""));
            reservationButton.setVisible(false);
            boxTime.setPromptText("Tidspunkt");


        });
    }
}