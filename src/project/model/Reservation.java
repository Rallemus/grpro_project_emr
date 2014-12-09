package project.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import project.DatabaseLoad;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Rasmus on 03-12-2014.
 */
public class Reservation {

    private DatabaseLoad database = new DatabaseLoad();
    private ArrayList<String> movies = new ArrayList();
    private ArrayList<Date> dates = new ArrayList();
    private ArrayList<Time> times = new ArrayList();
    private int numberOfRows;
    private int numberOfSeats;
    private int numberOfSeatsInARow;
    private GridPane seatsGrid;


    public Reservation () {
        ArrayList[] shows = database.getFromDatabase("SELECT * FROM shows", "shows");
        movies = shows[0];
        dates = shows[1];
        times = shows[2];
        System.out.println("Constructed successfully");
    }

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


        seatsGrid = new GridPane();
        seatsGrid.setHgap(15);
        seatsGrid.setVgap(15);
        seatsGrid.setAlignment(Pos.CENTER);

        final Seat[][] seat = new Seat[numberOfRows][numberOfSeats];
        for (int row = 0; row < seat.length; row++) {
            for (int seatNumber = 0; seatNumber < seat.length; seatNumber++) {
                //int seatsLeftInRow = numberOfSeatsInARow - seatNumber - 1;
                int shownSeatNumber;

                seat[row][seatNumber] = new Seat("");
                seat[row][seatNumber].setPrefSize(35, 35);

                if (seat[row][seatNumber].isFree()) {
                    seat[row][seatNumber].setStyle("-fx-background-color: green;");
                    seat[row][seatNumber].setOnMouseEntered(me -> seatsGrid.setCursor(Cursor.HAND));
                    seat[row][seatNumber].setOnMouseExited(me -> seatsGrid.setCursor(Cursor.DEFAULT));
                } else {
                    seat[row][seatNumber].setStyle("-fx-background-color: red;");
                    seat[row][seatNumber].setDisable(true);
                }
                seatsGrid.add(seat[row][seatNumber], seatNumber, row);

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



    public ArrayList<String> getMovies() {
        return movies;
    }

    public ArrayList<Date> getDates() {
        return dates;
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfSeatsInARow() {
        return numberOfSeatsInARow;
    }

    public GridPane getSeatsGrid() {
        return seatsGrid;
    }
}
