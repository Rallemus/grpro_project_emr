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
    private ObservableList showTitle;
    private ObservableList showDate;
    private ObservableList showTime;



    /*    public Cinema(String shows1, String date, String time){
        this.shows1 = shows1;
        this.date = date;
        this.time = time;
    }
*/
    public static void main(String[] args) {

        Cinema cinema = new Cinema();
        cinema.getShow();
        cinema.getDate();
        cinema.getTime();
    }

    public ObservableList getShow() {
        ObservableList<String> showTitle = FXCollections.observableArrayList(); //creates list to hold data to show
                                                                                // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows","shows"); //fills an arraylist with data from database table "shows"
        showTitle.setAll(data[0]); //0 refers to the first column in the table "shows" which holds titles.
        return showTitle;
    }


    public ObservableList getDate() {
        ObservableList<String> showDate = FXCollections.observableArrayList(); //creates list to hold data to show
                                                                                // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows","shows"); //fills an arraylist with data from database table "shows"
        showDate.setAll(data[1]);      //1 refers to the second column in the table "shows" which holds dates.
        /*for(Date i : showDate) {
            i = i.toString();
        }*/
        return showDate;
    }

    public ObservableList getTime() {
        ObservableList<String> showTime = FXCollections.observableArrayList(); //creates list to hold data to show
                                                                                // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows","shows"); //fills an arraylist with data from database table "shows"
        showTime.setAll(data[2]); //2 refers to the third column in the table "shows" which holds times.
        return showTime;
    }

}
