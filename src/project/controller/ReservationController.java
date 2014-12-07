package project.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import project.model.Reservation;

import java.awt.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Rasmus on 03-12-2014.
 */
public class ReservationController {

    @FXML
    private ComboBox<String> moviesBox;
    @FXML
    private ComboBox<Date> datesBox;
    @FXML
    private ComboBox<Time> timesBox;


    @FXML
    public void initialize(){
        moviesBox.setItems((javafx.collections.ObservableList) new Reservation().getMovies());
        datesBox.setItems((javafx.collections.ObservableList) new Reservation().getDates());
        timesBox.setItems((javafx.collections.ObservableList) new Reservation().getTimes());

    }
}
