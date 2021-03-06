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


    public static void main(String[] args) {

        Cinema cinema = new Cinema();
  }


    public ObservableList getShow(String showdate, String showtime) {
        ObservableList<String> showTitle = FXCollections.observableArrayList(); //creates list to hold data to show
                                                                                // in the choicebox.
        String WhereClause = new String();
        String sqlStatement = new String();

        if(showdate == "" && showtime == "") {
            WhereClause = "" + "WHERE ";
        }
        else if (showdate == "" && showtime != "") {
            WhereClause = "WHERE ShowTime = '" + showtime + "'" + "AND ";
        }
        else if (showdate != "" && showtime == "") {
            WhereClause = "WHERE ShowDate = '" + showdate + "'" + "AND ";
        }
        else {
            WhereClause = "WHERE ShowDate = '" + showdate + "' AND ShowTime = '" + showtime + "'" + "AND ";
        }
        sqlStatement = "SELECT DISTINCT ShowTitle FROM shows " + WhereClause +
                "ShowDate <= curdate() + INTERVAL DAYOFWEEK(curdate())+14 DAY AND ShowDate > curdate()";

        ArrayList[] data = database.getFromDatabase(sqlStatement, "showTitle");

        showTitle.setAll(data[0]); //0 refers to the first column in the table "shows" which holds titles.
        return showTitle;
    }

    public ObservableList getDate(String showtitle, String showtime) {
        ObservableList<String> showDate = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        String WhereClause = new String();
        String sqlStatement = new String();

        if(showtitle == "" && showtime == "") {
            WhereClause = "" + "WHERE ";
        }
        else if (showtitle == "" && showtime != "") {
            WhereClause = "WHERE ShowTime = '" + showtime + "'" + "AND ";
        }
        else if (showtitle != "" && showtime == "") {
            WhereClause = "WHERE ShowTitle = '" + showtitle + "'" + "AND ";
        }
        else {
            WhereClause = "WHERE ShowTitle = '" + showtitle + "' AND ShowTime = '" + showtime + "'" + "AND ";
        }
        sqlStatement = "SELECT DISTINCT ShowDate FROM shows " + WhereClause +
                "ShowDate <= curdate() + INTERVAL DAYOFWEEK(curdate())+14 DAY AND ShowDate > curdate()";

        ArrayList[] data = database.getFromDatabase(sqlStatement, "showDate");
        showDate.setAll(data[0]); //0 refers to the first column in the table "shows" which holds titles.
        return showDate;
    }
    public ObservableList getTime(String showdate, String showtitle) {
        ObservableList<String> showTime = FXCollections.observableArrayList(); //creates list to hold data to show
        // in the choicebox.
        String WhereClause = new String();
        String sqlStatement = new String();

        if(showdate == "" && showtitle == "") {
            WhereClause = "" + "WHERE ";
        }
        else if (showdate == "" && showtitle != "") {
            WhereClause = "WHERE ShowTitle = '" + showtitle + "'" + "AND ";
        }
        else if (showdate != "" && showtitle == "") {
            WhereClause = "WHERE ShowDate = '" + showdate + "'" + "AND ";
        }
        else {
            WhereClause = "WHERE ShowDate = '" + showdate + "' AND ShowTitle = '" + showtitle + "'" + "AND ";
        }

        sqlStatement = "SELECT DISTINCT ShowTime FROM shows " + WhereClause +
                "ShowDate <= curdate() + INTERVAL DAYOFWEEK(curdate())+14 DAY AND ShowDate > curdate()";

        ArrayList[] data = database.getFromDatabase(sqlStatement, "showTime");
        showTime.setAll(data[0]); //0 refers to the first column in the table "shows" which holds titles.
        return showTime;
    }
}
