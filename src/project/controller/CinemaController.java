package project.controller;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import project.model.Cinema;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

    public CinemaController(){

    }

    /**
     * This method fills out the choicebox made in JavaFX with data from the database by creating a new Cinema
     * object, and calling its getShow method which is responsible for accessing data from the database.
     */
    @FXML
    public void initialize(){
        boxShows.setItems(new Cinema().getShow());
        boxDate.setItems(new Cinema().getDate());
        boxTime.setItems(new Cinema().getTime());

        }

    }