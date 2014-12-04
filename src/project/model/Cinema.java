package project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import project.DatabaseLoad;

import java.util.ArrayList;

/**
 * Created by Maria on 02-12-2014.
 */
public class Cinema {
    private String shows1;
    private String date;
    private String time;
    private DatabaseLoad database = new DatabaseLoad();


/*    public Cinema(String shows1, String date, String time){
        this.shows1 = shows1;
        this.date = date;
        this.time = time;
    }
*/
    public static void main(String[] args) {

        Cinema cinema = new Cinema();
        cinema.getShow();
       // cinema.getDate();
        cinema.getTime();
    }

    public ObservableList getShow() {
        ObservableList<String> showlist1 = FXCollections.observableArrayList();
        ArrayList[] data = database.getFromDatabase("shows");
        showlist1.setAll(data[0]);
        System.out.println(showlist1.get(0));
        return showlist1;
    }


  /*  public ObservableList getDate() {
        ObservableList<String> showlist2 = FXCollections.observableArrayList();
        ArrayList[] data = database.getFromDatabase("shows");
        showlist2.setAll(data[1]);
        System.out.println(showlist2.get(0));
        return showlist2;
    }
*/
    public ObservableList getTime() {
        ObservableList<String> showlist3 = FXCollections.observableArrayList();
        ArrayList[] data = database.getFromDatabase("shows");
        showlist3.setAll(data[2]);
        System.out.println(showlist3.get(0));
        return showlist3;
    }

}
