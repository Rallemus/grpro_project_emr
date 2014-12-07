package project.controller;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import project.model.Cinema;
import javafx.beans.value.ChangeListener;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Maria on 02-12-2014.
 */
public class CinemaController {

    @FXML
    private MenuBar shows;
    @FXML
    private MenuBar date;
    @FXML
    private MenuBar time;
    @FXML
    private ComboBox<String> boxShows;
    @FXML
    private ComboBox<Date> boxDate;
    @FXML
    private ComboBox<Time> boxTime;

    public CinemaController() {
    }

    /**
     * This method fills out the choicebox made in JavaFX with data from the database by creating a new Cinema
     * object, and calling its getShow method which is responsible for accessing data from the database.
     */
    @FXML
    public void initialize() {
        boxShows.setOnAction((event) -> {
            if(boxDate.getSelectionModel().isEmpty() && boxTime.getSelectionModel().isEmpty()){
                String showtitle = boxShows.getSelectionModel().getSelectedItem().toString();
                boxDate.setItems(new Cinema().getDate(showtitle, ""));
                boxTime.setItems(new Cinema().getTime("", showtitle));
            }
            else if(!boxDate.getSelectionModel().isEmpty() && boxTime.getSelectionModel().isEmpty()){
                String showdate = boxDate.getSelectionModel().getSelectedItem().toString();
                String showtitle = boxShows.getSelectionModel().getSelectedItem().toString();
                boxTime.setItems(new Cinema().getTime(showdate, showtitle));
            }
            else if(boxDate.getSelectionModel().isEmpty() && !boxTime.getSelectionModel().isEmpty()){
                String showtitle = boxShows.getSelectionModel().getSelectedItem().toString();
                String showtime = boxTime.getSelectionModel().getSelectedItem().toString();
                boxDate.setItems(new Cinema().getDate(showtitle, showtime));
            }
        });

        boxDate.setOnAction((event) -> {
            if(boxShows.getSelectionModel().isEmpty() && boxTime.getSelectionModel().isEmpty()){
                String showdate = boxDate.getSelectionModel().getSelectedItem().toString();
                boxShows.setItems(new Cinema().getShow(showdate, ""));
                boxTime.setItems(new Cinema().getTime(showdate, ""));
            }

            else if(!boxShows.getSelectionModel().isEmpty() && boxTime.getSelectionModel().isEmpty()){
                String showdate = boxDate.getSelectionModel().getSelectedItem().toString();
                String showtitle = boxShows.getSelectionModel().getSelectedItem().toString();
                boxTime.setItems(new Cinema().getTime(showdate, showtitle));
            }

            else if(boxShows.getSelectionModel().isEmpty() && !boxTime.getSelectionModel().isEmpty()){
                String showdate = boxDate.getSelectionModel().getSelectedItem().toString();
                String showtime = boxTime.getSelectionModel().getSelectedItem().toString();
                boxShows.setItems(new Cinema().getDate(showdate, showtime));
            }
        });

        boxTime.setOnAction((event) -> {
            if(boxDate.getSelectionModel().isEmpty() && boxShows.getSelectionModel().isEmpty()){
                String showtime = boxTime.getSelectionModel().getSelectedItem().toString();
                boxDate.setItems(new Cinema().getDate("", showtime));
                boxShows.setItems(new Cinema().getTime("", showtime));
            }
            else if(!boxDate.getSelectionModel().isEmpty() && boxShows.getSelectionModel().isEmpty()){
                String showdate = boxDate.getSelectionModel().getSelectedItem().toString();
                String showtime = boxTime.getSelectionModel().getSelectedItem().toString();
                boxShows.setItems(new Cinema().getTime(showdate, showtime));
            }
            else if(boxDate.getSelectionModel().isEmpty() && !boxShows.getSelectionModel().isEmpty()){
                String showtitle = boxShows.getSelectionModel().getSelectedItem().toString();
                String showtime = boxTime.getSelectionModel().getSelectedItem().toString();
                boxDate.setItems(new Cinema().getDate(showtitle, showtime));
            }
        });

        boxShows.setItems(new Cinema().getShow("" , ""));
        boxDate.setItems(new Cinema().getDate("", ""));
        boxTime.setItems(new Cinema().getTime("", ""));
   /*     ChangeListener listener = new ChangeListener()
        {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (!boxShows.getSelectionModel().isEmpty()) {
                    boxDate.setItems(new Cinema().getDate(boxShows.getSelectionModel().getSelectedItem().toString(), boxTime.getSelectionModel().getSelectedItem().toString()));
                    boxTime.setItems(new Cinema().getTime(boxShows.getSelectionModel().getSelectedItem().toString(), boxDate.getSelectionModel().getSelectedItem().toString()));
                }
                if (!boxDate.getSelectionModel().isEmpty()) {
                    boxShows.setItems(new Cinema().getDate(boxDate.getSelectionModel().getSelectedItem().toString(), boxTime.getSelectionModel().getSelectedItem().toString()));
                    boxTime.setItems(new Cinema().getTime(boxShows.getSelectionModel().getSelectedItem().toString(), boxDate.getSelectionModel().getSelectedItem().toString()));
                }
                if (!boxTime.getSelectionModel().isEmpty()) {
                    boxDate.setItems(new Cinema().getDate(boxShows.getSelectionModel().getSelectedItem().toString(), boxTime.getSelectionModel().getSelectedItem().toString()));
                    boxShows.setItems(new Cinema().getTime(boxTime.getSelectionModel().getSelectedItem().toString(), boxDate.getSelectionModel().getSelectedItem().toString()));

            String showtitle = boxShows.getSelectionModel().getSelectedItem().toString();
            String showdate = boxDate.getSelectionModel().getSelectedItem().toString();
            String showtime = boxShows.getSelectionModel().getSelectedItem().toString();

                boxShows.setItems(new Cinema().getShow(showdate, showtime));
                boxDate.setItems(new Cinema().getDate(showtitle, showtime));
                boxTime.setItems(new Cinema().getTime(showdate, showtime));
            }

        };

        boxShows.getSelectionModel().selectedItemProperty().addListener((ChangeListener<? super String>) listener);
            boxDate.getSelectionModel().selectedItemProperty().addListener((ChangeListener<? super Date>) listener);
            boxTime.getSelectionModel().selectedItemProperty().addListener((ChangeListener<? super Time>) listener);
*/
        }
}
