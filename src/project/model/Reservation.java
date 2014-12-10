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

    public Reservation () {
        ArrayList[] shows = database.getFromDatabase("SELECT * FROM shows", "shows");
        movies = shows[0];
        dates = shows[1];
        times = shows[2];
        System.out.println("Constructed successfully");



        int currentTheater = (int) database.getFromDatabase("SELECT * FROM shows WHERE ShowID=" + 1, "shows")[3].get(0);
        System.out.println("Theater number: " + currentTheater);
        ArrayList[] theater = database.getFromDatabase("SELECT * FROM theater WHERE Theater=" + currentTheater, "theater");

        numberOfRows = (int) theater[1].get(theater[1].size() - 1);
        numberOfSeatsInARow = (int) theater[2].get(theater[2].size() - 1);
        numberOfSeats = numberOfSeatsInARow * numberOfRows;
        System.out.println("Rows: " + numberOfRows);
        System.out.println("Seats: " + numberOfSeats);
        System.out.println("Seats per row:" + numberOfSeatsInARow);
    }

    public ArrayList loadOccupiedSeats(int showID) {
        ArrayList[] reservations = database.getFromDatabase("SELECT * FROM reservations WHERE ShowID=" + showID, "reservations");
        ArrayList row = reservations[3];
        ArrayList seats = reservations[4];
        ArrayList occupiedPairs = new ArrayList();
        for(int i = 0 ; i < row.size() ; i++) {
            //occupiedPairs.add(new int[] {(int) row.get(i), (int) seats.get(i)});
            occupiedPairs.add(""+ row.get(i) + seats.get(i));
        }
        return occupiedPairs;
    }

    public void initializeSeats(int showID) {

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
}
