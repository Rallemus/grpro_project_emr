package project.controller;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import project.model.Cinema;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

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
    private ChoiceBox<String> boxShows;
    @FXML
    private ChoiceBox<Date> boxDate;
    @FXML
    private ChoiceBox<Time> boxTime;

    public CinemaController(){

    }

    /**
     * This method fills out the choicebox made in JavaFX with data from the database by creating a new Cinema
     * object, and calling its getShow method which is responsible for accessing data from the database.
     */
    @FXML
    public void initialize(){
     //   StringConverter sc = new NumberStringConverter();
     //   boxShows.setConverter(sc);
        boxShows.setItems(new Cinema().getShow());
        boxDate.setItems(new Cinema().getDate());
        boxTime.setItems(new Cinema().getTime());

    }

}