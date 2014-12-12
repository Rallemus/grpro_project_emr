package project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import project.DatabaseInsert;
import project.DatabaseLoad;
import project.model.Reservation;
import project.model.Seat;

import java.util.ArrayList;

/**
 * Created by Rasmus on 03-12-2014.
 */
public class ReservationController {

    private Reservation reservation = new Reservation();
    private DatabaseLoad databaseLoad = new DatabaseLoad();
    private DatabaseInsert databaseInsert = new DatabaseInsert();
    private int theater;
    private ObservableList numberOfSeatsSelectedItems = FXCollections.observableArrayList();
    private int numberOfSeatsToSelect = 1;
    private int selectedRow;
    private int selectedSeat;
    private int showID = 2; //hardcoded for now


    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private GridPane seatsGridContainer;
    @FXML
    private VBox movieScreenBox;
    @FXML
    private Text theaterNumber;
    @FXML
    private Text freeSeats;
    @FXML
    private ComboBox seatsSelectedBox;
    @FXML
    private Button reserveButton;
    @FXML
    private Text movieTitleText;
    @FXML
    private Text movieDateText;
    @FXML
    private Text movieTimeText;


    public ReservationController() {
        reservation.loadTheaterFromDatabase(showID);
        theater = reservation.getTheaterNumber();
        numberOfSeatsSelectedItems.addAll(1,2,3,4,5,6,7,8);
    }


    @FXML
    public void initialize() {
        //int numberOfSeatsSelected;
        seatsSelectedBox.setItems(numberOfSeatsSelectedItems);
        seatsSelectedBox.setOnAction((event) -> {
            numberOfSeatsToSelect = (int) seatsSelectedBox.getSelectionModel().getSelectedItem();
        });
        movieScreenBox.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        seatsGridContainer.setHgap(8);
        seatsGridContainer.setVgap(8);
        seatsGridContainer.setAlignment(Pos.CENTER);
        ArrayList occupiedSeats = reservation.loadOccupiedSeats(theater);

        Seat[][] seat = new Seat[reservation.getNumberOfRows()][reservation.getNumberOfSeatsInARow()];
        for (int row = 0; row < seat.length; row++) {
            for (int seatNumber = 0; seatNumber < seat[0].length; seatNumber++) {
                seat[row][seatNumber] = new Seat("");
                seat[row][seatNumber].setPrefSize(30, 30);

                //
                final int finalRow = row;
                final int finalSeatNumber = seatNumber;
                seat[row][seatNumber].setOnMouseClicked(arg0 -> {
                    selectedRow = finalRow;
                    selectedSeat = finalSeatNumber;
                    for (int i = 0; i < seat.length; i++) {
                        for (int j = 0; j < seat[0].length; j++) {
                            if (seat[i][j].isFree()) {
                                seat[i][j].setStyle("-fx-background-color: green;");
                                seat[i][j].setSelected(false);
                            }
                        }
                    }
                    // check: does the seat selection extend the boundaries of the theater or go into already booked seats?
                    if(seat[finalRow].length <= finalSeatNumber-1 + numberOfSeatsToSelect) {
                        int seatsLeft = seat[finalRow].length - finalSeatNumber;
                        seatsSelectedBox.setValue(seatsLeft);
                        for(int i = 0 ; i < seatsLeft ; i++) {
                            seat[finalRow][finalSeatNumber + i].setStyle("-fx-background-color: dodgerblue;");
                        }
                    }
                    else {
                        for(int i = 0 ; i < numberOfSeatsToSelect ; i++) {
                            if(!seat[finalRow][finalSeatNumber + i].isFree()) {
                                seatsSelectedBox.setValue(i);
                                break;
                            }
                            seat[finalRow][finalSeatNumber + i].setStyle("-fx-background-color: dodgerblue;");
                            seat[finalRow][finalSeatNumber + i].setSelected(true);
                        }
                    }
                });

                // checks and sets which seats are booked
                if(occupiedSeats.contains("" + row + seatNumber)) {
                    seat[row][seatNumber].setIsFree(false);
                }

                //set free seats to change the cursor on mouseover
                if (seat[row][seatNumber].isFree()) {
                    seat[row][seatNumber].setStyle("-fx-background-color: green;");
                    seat[row][seatNumber].setOnMouseEntered(me -> seatsGridContainer.setCursor(Cursor.HAND));
                    seat[row][seatNumber].setOnMouseExited(me -> seatsGridContainer.setCursor(Cursor.DEFAULT));
                }
                // set booked seats to display as red
                else {
                    seat[row][seatNumber].setStyle("-fx-background-color: red;");
                    seat[row][seatNumber].setDisable(true);
                }
                seatsGridContainer.add(seat[row][seatNumber], seatNumber, row);
            }
        }


        reserveButton.setOnAction((event) -> {
            databaseInsert.newPersonInDatabase(nameField.getText(),phoneField.getText());
            ArrayList nextPersonIDs = databaseLoad.getFromDatabase(
                    "SELECT * FROM person WHERE PhoneNumber=" + phoneField.getText(),"person")[2];
            int nextPersonID = (int) nextPersonIDs.get(nextPersonIDs.size() - 1);

            ArrayList arr = databaseLoad.getFromDatabase("SELECT * FROM reservations","reservations")[0];
            int nextReservationID = (int) arr.get(arr.size()-1) + 1;


            for(int i = 0; i < numberOfSeatsToSelect ; i++) {
                databaseInsert.newReservationInDatabase(
                        nextReservationID, nextPersonID, showID, selectedRow, selectedSeat+i);
            }
            initialize();
        });

        ArrayList[] shows = databaseLoad.getFromDatabase("SELECT * FROM shows WHERE ShowID=" + showID, "shows");
        movieTimeText.setText("Film: " + shows[0].get(0));
        movieDateText.setText("Dato: " + shows[1].get(0).toString());
        movieTimeText.setText("Tidspunkt:  " + shows[2].get(0).toString());

        theaterNumber.setText("Sal nr: " + theater);
        freeSeats.setText("Ledige sæder: " + (reservation.getNumberOfSeats()-occupiedSeats.size()));
    }
}
