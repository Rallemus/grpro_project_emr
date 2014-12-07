package project.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
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

    public Reservation () {
        ArrayList[] shows = database.getFromDatabase("SELECT * FROM shows", "shows");
        movies = shows[0];
        dates = shows[1];
        times = shows[2];
    }

    public static void main(String[] args) {
        Reservation res = new Reservation();
        System.out.println(res.movies);
        System.out.println(res.dates);
        System.out.println(res.times);
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
}
