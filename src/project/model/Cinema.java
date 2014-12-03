package project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import project.DatabaseLoad;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Maria on 02-12-2014.
 */
public class Cinema {
    private String shows1;
    private String date;
    private String time;
    private DatabaseLoad database = new DatabaseLoad();


    public Cinema(String shows1, String date, String time){
        this.shows1 = shows1;
        this.date = date;
        this.time = time;
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema(shows, date, time);
        cinema.getShow();
        cinema.getDate();
        cinema.getTime();
    }

    public void getShow() throws UnsupportedEncodingException {
        ObservableList<String> showlist = FXCollections.observableArrayList();
        final ChoiceBox<String> chooser = new ChoiceBox<>(showlist);
        chooser.getSelectionModel().select(0);
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
