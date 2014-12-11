package project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import project.model.Reservation;
import project.model.Seat;

import java.util.ArrayList;

/**
 * Created by Rasmus on 03-12-2014.
 */
public class ReservationController {

    private Reservation reservation = new Reservation();
    private int theater = 1;
    private ObservableList numberOfSeatsSelectedItems = FXCollections.observableArrayList();
    private int numberOfSeatsToSelect = 1;

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

    public ReservationController() {
        reservation.loadTheaterFromDatabase(1);
        numberOfSeatsSelectedItems.addAll(1,2,3,4,5,6,7,8);
    }


    @FXML
    public void initialize(){
        seatsSelectedBox.setItems(numberOfSeatsSelectedItems);
        seatsSelectedBox.setOnAction((event) -> {
            numberOfSeatsToSelect = (int) seatsSelectedBox.getSelectionModel().getSelectedItem();
        });

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

                final int finalRow = row;
                final int finalSeatNumber = seatNumber;
                seat[row][seatNumber].setOnMouseClicked(arg0 -> {
                    for (int i = 0; i < seat.length; i++) {
                        for (int j = 0; j < seat.length; j++) {
                            if (seat[i][j].isFree()) {
                                seat[i][j].setStyle("-fx-background-color: green;");
                            }
                        }
                    }
                    for(int i = 0 ; i < numberOfSeatsToSelect ; i++) {
                        seat[finalRow][finalSeatNumber + i].setStyle("-fx-background-color: dodgerblue;");
                    }
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

        theaterNumber.setText("Sal nr: " + theater);
        freeSeats.setText("Ledige sæder: " + (reservation.getNumberOfSeats()-occupiedSeats.size()));
    }
}
