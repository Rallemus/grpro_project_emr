package project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import project.DatabaseLoad;

import java.util.ArrayList;
import project.controller.CinemaController;

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
    private String show;


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
        boolean showTitleFull = true;
        return showTitle;
    }

    public ObservableList getDate() {
        ObservableList<String> showDate = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows", "shows");
        //fills an arraylist with data from database table "shows"
        showDate.setAll(data[1]);      //1 refers to the second column in the table "shows" which holds dates.
        return showDate;
    }

    public ObservableList getTime() {
        ObservableList<String> showTime = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows","shows"); //fills an arraylist with data from database table "shows"
        showTime.setAll(data[2]); //2 refers to the third column in the table "shows" which holds times.
        return showTime;
    }

    public ObservableList getShowDependDate() {
        ObservableList<String> showTitleDate = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows WHERE ShowTitle = 'ShowTitle'","shows");
        //fills an arraylist with data from database table "shows"
        showTitleDate.setAll(data[0]); //0 refers to the first column in the table "shows" which holds titles.
        return showTitleDate;
    }

    public ObservableList getDateDependShow() {
        ObservableList<String> showDateTitle = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows WHERE ShowTitle = selected","shows");
        //fills an arraylist with data from database table "shows"
        showDateTitle.setAll(data[1]); //0 refers to the first column in the table "shows" which holds titles.
        return showDateTitle;
    }

    public ObservableList getShowDependTime() {
        ObservableList<String> showTitleTime = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT ShowTime FROM shows WHERE ShowTitle = boxShow.getValue()","shows");
        //fills an arraylist with data from database table "shows"
        showTitleTime.setAll(data[0]); //0 refers to the first column in the table "shows" which holds titles.
        return showTitleTime;
    }

    public ObservableList getTimeDependShow() {
        ObservableList<String> showTimeTitle = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows WHERE ShowTitle = 'selected'","shows");
        //fills an arraylist with data from database table "shows"
        showTimeTitle.setAll(data[2]); //0 refers to the first column in the table "shows" which holds titles.
        return showTimeTitle;
    }

    public ObservableList getDateDependTime() {
        ObservableList<String> showDateTime = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows WHERE ShowDate = ShowTime","shows");
        //fills an arraylist with data from database table "shows"
        showDateTime.setAll(data[1]); //0 refers to the first column in the table "shows" which holds titles.
        return showDateTime;
    }

    public ObservableList getTimeDependDate() {
        ObservableList<String> showTimeDate = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows WHERE ShowDate = ShowTime","shows");
        //fills an arraylist with data from database table "shows"
        showTimeDate.setAll(data[2]); //0 refers to the first column in the table "shows" which holds titles.
        return showTimeDate;
    }

}
