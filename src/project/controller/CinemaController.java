package project.controller;
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

    @FXML
    public void initialize(){

        boxShows.setItems(new Cinema().getShow());
 //       boxDate.setItems(getDate());
 //       boxTime.setItems(getTime());

    }

}