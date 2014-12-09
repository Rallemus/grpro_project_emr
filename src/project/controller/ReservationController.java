package project.controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import project.DatabaseLoad;
import project.model.Reservation;
import project.model.Seat;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

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
    private Pane seatsGridContainer;


    @FXML
    public void initialize(){

        //moviesBox.setItems((javafx.collections.ObservableList) new Reservation().getMovies());
        //datesBox.setItems((javafx.collections.ObservableList) new Reservation().getDates());
        //timesBox.setItems((javafx.collections.ObservableList) new Reservation().getTimes());


        Reservation reservation = new Reservation();
        reservation.initializeSeats(1);
        seatsGridContainer = reservation.getSeatsGrid();

    }
}
