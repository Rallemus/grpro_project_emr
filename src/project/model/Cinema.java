package project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import project.DatabaseLoad;

import java.lang.reflect.Array;
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
    private String entitel;

    /*    public Cinema(String shows1, String date, String time){
        this.shows1 = shows1;
        this.date = date;
        this.time = time;
    }
*/

    public void getSelectedshows() {
    }

    public static void main(String[] args) {

        Cinema cinema = new Cinema();
  /*      cinema.getShow();
        cinema.getDate();
        cinema.getTime();
  */  }


    public ObservableList getShow(String showdate, String showtime) {
        ObservableList<String> showTitle = FXCollections.observableArrayList(); //creates list to hold data to show
                                                                                // in the choicebox.
        String WhereClause = new String();
        String sqlStatement = new String();

        if(showdate == "" && showtime == "") {
            WhereClause = "";
        }
        else if (showdate == "" && showtime != "") {
            WhereClause = "WHERE ShowTime = '" + showtime + "'";
        }
        else if (showdate != "" && showtime == "") {
            WhereClause = "WHERE ShowDate = '" + showdate + "'";
        }
        else {
            WhereClause = "WHERE ShowDate = '" + showdate + "' AND ShowTime = '" + showtime + "'";
        }

        sqlStatement = "SELECT DISTINCT ShowTitle FROM shows " + WhereClause;

        ArrayList[] data = database.getFromDb(sqlStatement, "showTitle");

        showTitle.setAll(data[0]); //0 refers to the first column in the table "shows" which holds titles.
        return showTitle;
    }

    public ObservableList getDate(String showtitle, String showtime) {
        ObservableList<String> showDate = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        String WhereClause = new String();
        String sqlStatement = new String();

        if(showtitle == "" && showtime == "") {
            WhereClause = "";
        }
        else if (showtitle == "" && showtime != "") {
            WhereClause = "WHERE ShowTime = '" + showtime + "'";
        }
        else if (showtitle != "" && showtime == "") {
            WhereClause = "WHERE ShowTitle = '" + showtitle + "'";
        }
        else {
            WhereClause = "WHERE ShowTitle = '" + showtitle + "' AND ShowTime = '" + showtime + "'";
        }
        sqlStatement = "SELECT DISTINCT ShowDate FROM shows " + WhereClause;

        ArrayList[] data = database.getFromDb(sqlStatement, "showDate");
        showDate.setAll(data[0]); //0 refers to the first column in the table "shows" which holds titles.
        return showDate;
    }
    public ObservableList getTime(String showdate, String showtitle) {
        ObservableList<String> showTime = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        String WhereClause = new String();
        String sqlStatement = new String();

        if(showdate == "" && showtitle == "") {
            WhereClause = "";
        }
        else if (showdate == "" && showtitle != "") {
            WhereClause = "WHERE ShowTitle = '" + showtitle + "'";
        }
        else if (showdate != "" && showtitle == "") {
            WhereClause = "WHERE ShowDate = '" + showdate + "'";
        }
        else {
            WhereClause = "WHERE ShowDate = '" + showdate + "' AND ShowTitle = '" + showtitle + "'";
        }

        sqlStatement = "SELECT DISTINCT ShowTime FROM shows " + WhereClause;

        ArrayList[] data = database.getFromDb(sqlStatement, "showTime");
        showTime.setAll(data[0]); //0 refers to the first column in the table "shows" which holds titles.
        return showTime;
    }

/*    public ObservableList getShowDependDate() {
        ObservableList<String> showTitleDate = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows WHERE ShowTitle = 'ShowTitle'","shows");
        //fills an arraylist with data from database table "shows"
        showTitleDate.setAll(data[0]); //0 refers to the first column in the table "shows" which holds titles.
        return showTitleDate;
    }

    public ObservableList getDateDependShow(String showthetitle) {
        Cinema cine = new Cinema();
        ObservableList<String> showDateTitle = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT DISTINCT ShowTitle, ShowDate, CAST('00:00:00' AS TIME) AS ShowTime FROM shows WHERE ShowTitle = " + "\"" + showthetitle + "\"","shows");
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

    public ObservableList getTimeDependShow(String showthetitle) {
        ObservableList<String> showTimeTitle = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT DISTINCT ShowTitle, ShowDate, CAST('00:00:00' AS TIME) AS ShowTime FROM shows WHERE ShowTitle = " + "\"" + showthetitle + "\"","shows");
        //fills an arraylist with data from database table "shows"
        showTimeTitle.setAll(data[2]); //0 refers to the first column in the table "shows" which holds titles.
        return showTimeTitle;
    }

    public ObservableList getDateDependTime() {
        ObservableList<String> showDateTime = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows WHERE ShowDate = " + entitel,"shows");
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
*/
}
