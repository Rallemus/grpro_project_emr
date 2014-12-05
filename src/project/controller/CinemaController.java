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
    public String selected;

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
        selected = boxShows.getSelectionModel().getSelectedItem();
        boxShows.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String t, String t1) {
                if(boxDate.getSelectionModel().isEmpty() && boxTime.getSelectionModel().isEmpty()){
                    boxDate.setItems(new Cinema().getDateDependShow());
                    boxTime.setItems(new Cinema().getTimeDependShow());
                }

            }
        });

/*        boxDate.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String t, String t1) {
                if(!boxDate.getItems().isEmpty()){
                    boxShows.setItems(new Cinema().getShowDependDate());
                    boxTime.setItems(new Cinema().getTimeDependDate());
                }

            }
        });

        boxTime.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String t, String t1) {
                if(!boxTime.getItems().isEmpty()){
                    boxShows.setItems(new Cinema().getShowDependTime());
                    boxDate.setItems(new Cinema().getDateDependTime());
                }

            }
        });
       */ }


    }