package project.controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import project.DatabaseLoad;
import project.model.Reservation;
import project.model.Seat;

import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by Rasmus on 03-12-2014.
 */
public class ReservationController {

    private Reservation reservation = new Reservation();
    private int numberOfRows;
    private int numberOfSeats;
    private int numberOfSeatsInARow;
    private int theater = 1;
    private int numberOfSeatsSelected;

    @FXML
    private GridPane seatsGridContainer;
    @FXML
    private Text theaterNumber;
    @FXML
    private Text freeSeats;
    @FXML
    private ComboBox seatsSelectedBox;
    @FXML
    private Button reserveButton;


    @FXML
    public void initialize(){



        seatsGridContainer.setHgap(15);
        seatsGridContainer.setVgap(15);
        seatsGridContainer.setAlignment(Pos.CENTER);
        ArrayList occupiedSeats = reservation.loadOccupiedSeats(theater);

        Seat[][] seat = new Seat[reservation.getNumberOfRows()][reservation.getNumberOfSeatsInARow()];
        //Seat[][] seat = new Seat[8][12]; use this line to try out hardcoded theater sizes when testing
        for (int row = 0; row < seat.length; row++) {
            for (int seatNumber = 0; seatNumber < seat[0].length; seatNumber++) {
                seat[row][seatNumber] = new Seat("");
                seat[row][seatNumber].setPrefSize(35, 35);

                seat[row][seatNumber].setOnMouseClicked(arg0 -> {
                    for (int i = 0; i < seat.length; i++) {
                        for (int j = 0; j < seat.length; j++) {
                            if (seat[i][j].isFree()) {
                                seat[i][j].setStyle("-fx-background-color: green;");
                            }
                        }
                    }
                    Seat selectedSeat = (Seat) arg0.getSource();
                    selectedSeat.setStyle("-fx-background-color: dodgerblue;");
                    // select more seats
                });

                if(occupiedSeats.contains("" + row + seatNumber)) {
                    seat[row][seatNumber].setIsFree(false);
                }

                if (seat[row][seatNumber].isFree()) {
                    seat[row][seatNumber].setStyle("-fx-background-color: green;");
                    seat[row][seatNumber].setOnMouseEntered(me -> seatsGridContainer.setCursor(Cursor.HAND));
                    seat[row][seatNumber].setOnMouseExited(me -> seatsGridContainer.setCursor(Cursor.DEFAULT));
                } else {
                    seat[row][seatNumber].setStyle("-fx-background-color: red;");
                    seat[row][seatNumber].setDisable(true);
                }

                seatsGridContainer.add(seat[row][seatNumber], seatNumber, row);
            }
        }
    }

/*
    public void initializeSeats(int showID) {
        //ArrayList[] reservations = database.getFromDatabase("SELECT * FROM reservations WHERE ShowID=" + showID, "reservations");

        int currentTheater = (int) database.getFromDatabase("SELECT * FROM shows WHERE ShowID=" + showID, "shows")[3].get(0);
        System.out.println("Theater number: " + currentTheater);
        ArrayList[] theater = database.getFromDatabase("SELECT * FROM theater WHERE Theater=" + currentTheater, "theater");

        numberOfRows = (int) theater[1].get(theater[1].size() - 1);
        numberOfSeatsInARow = (int) theater[2].get(theater[2].size() - 1);
        numberOfSeats = numberOfSeatsInARow * numberOfRows;
        System.out.println("Rows: " + numberOfRows);
        System.out.println("Seats: " + numberOfSeats);
        System.out.println("Seats per row:" + numberOfSeatsInARow);


        seatsGridContainer.setHgap(15);
        seatsGridContainer.setVgap(15);
        seatsGridContainer.setAlignment(Pos.CENTER);

        final Seat[][] seat = new Seat[numberOfRows][numberOfSeats];
        for (int row = 0; row < seat.length; row++) {
            for (int seatNumber = 0; seatNumber < seat.length; seatNumber++) {
                //int seatsLeftInRow = numberOfSeatsInARow - seatNumber - 1;
                int shownSeatNumber;

                seat[row][seatNumber] = new Seat("");
                seat[row][seatNumber].setPrefSize(35, 35);

                if (seat[row][seatNumber].isFree()) {
                    seat[row][seatNumber].setStyle("-fx-background-color: green;");
                    seat[row][seatNumber].setOnMouseEntered(me -> seatsGridContainer.setCursor(Cursor.HAND));
                    seat[row][seatNumber].setOnMouseExited(me -> seatsGridContainer.setCursor(Cursor.DEFAULT));
                } else {
                    seat[row][seatNumber].setStyle("-fx-background-color: red;");
                    seat[row][seatNumber].setDisable(true);
                }
                seatsGridContainer.add(seat[row][seatNumber], seatNumber, row);

                final int finalI = row;
                final int finalJ = seatNumber;
                seat[row][seatNumber].setOnMouseClicked(arg0 -> {
                    for (int i = 0; i < seat.length; i++) {
                        for (int j = 0; j < seat.length; j++) {

                            if (seat[i][j].isFree()) {
                                seat[i][j].setStyle("-fx-background-color: green;");
                            }

                        }
                    }
                    Seat selectedSeat = (Seat) arg0.getSource();
                    selectedSeat.setStyle("-fx-background-color: dodgerblue;");
                });
            }
        }
    }
    */
}
