package project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.DatabaseLoad;

import java.util.ArrayList;

/**
 * Created by Maria on 02-12-2014.
 */
public class Cinema {
    private String shows;
    private String date;
    private String time;
    private DatabaseLoad database = new DatabaseLoad();


    public Cinema(String shows, String date, String time){
        this.shows = time;
        this.date = time;
        this.time = time;
    }

    public static void main(String[] args)
    {
        Cinema cinema = new Cinema(shows, date, time);
        cinema.getShow();
        cinema.getDate();
        cinema.getTime();
    }

    public ObservableList<String> getShow()  {
        ObservableList<String> data = new FXCollections.observableArrayList();
        data.addAll(database.getFromDatabase(ShowTitle, shows));
    }

    public ObservableList<String> getDate()  {
        ObservableList<String> data = new FXCollections.observableArrayList();
        data.addAll(database.getFromDatabase(ShowDate, shows));
    }

    public ObservableList<String> getTime()  {
        ObservableList<String> data = new FXCollections.observableArrayList();
        data.addAll(database.getFromDatabase(ShowTime, shows));
    }
    
}
