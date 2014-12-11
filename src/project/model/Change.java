package project.model;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.DatabaseLoad;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Elise on 03-12-2014.
 */
public class Change {

    private DatabaseLoad database = new DatabaseLoad();
    private ObservableList name;



/*    public Change(String name, String phone, String shows) {

    }
*/




/*
 Retrieve the NameIDs from the reservations in the database.
*/
    public ArrayList getPersonID(int reservationid) {
        ArrayList[] data = database.getFromDatabase("SELECT DISTINCT PersonID FROM reservations WHERE ReservationID =" + reservationid, "personID");
        // fills an arraylist with data from the database table "reservations".
        return data[0]; //1 refers to the second column in the table "reservations" which is PersonID.
    }

/*
Retrieve the ShowIDs from the reservations in the database.
 */

    public ArrayList getShowID(int reservationid) {
        ArrayList[] data = database.getFromDatabase("SELECT DISTINCT ShowID FROM reservations WHERE ReservationID =" +reservationid, "showID");
        //fills an arraylist with data from the database table "reservations".
        return data[0]; //2 refers to the third column in the table "reservations" which is ShowID.

    }

 /*
    Retrieve the ReservationIDs frm the reservations in the database.
 */
    public ArrayList getReservationID() {
        ArrayList[] data = database.getFromDatabase("SELECT * FROM reservations", "reservations");
        //fills an arraylist with data from the row ReservationID in the table "reservations".
        return data[0]; //0 refers to the first column in the table "reservations" which is ReservationsID.
    }



    /*
    Get the names connected to the NameIDs (in the reservations).
 */
    public ArrayList getPersonName(int personid) {
        ArrayList[] data = database.getFromDatabase("SELECT DISTINCT Name FROM person WHERE PersonID = " +personid, "name");
        System.out.println(data[0]);
        return data[0];
    }

    /*
    Get the phonenumbers connected to the NameIDs (in the reservations).
     */
    public String getPhoneNumber(int personid) {
        ArrayList[] data = database.getFromDatabase("SELECT DISTINCT PhoneNumber FROM person WHERE PersonID=" +personid, "phone");
        return (String) data[1].get(0);
    }


 /*
    Get the movietitles connected to the ShowIDs.
 */
    public ArrayList getMovieTitle(int showid) {
        ArrayList[] data = database.getFromDatabase("SELECT DISTINCT ShowTitle FROM shows WHERE ShowID=" +showid, "showTitle");
        return data[0];
    }

    public Date getDate(int showid) {
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows WHERE ShowID=" + showid, "shows");
        return (Date) data[1].get(0);

    }

    public Time getTime(int showid) {
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows WHERE ShowID=" + showid, "shows");
        return (Time) data[2].get(0);
    }

    public int getTheaterNumber(int showid) {
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows WHERE ShowID=" + showid, "shows");
        return (int) data[3].get(0);
   }

/*
Get the rows connected to the ReservationIDs.
*/
   public int getRow(int reservationid) {
       ArrayList[] data = database.getFromDatabase("SELECT * FROM reservations WHERE ReservationID =" +reservationid, "reservations");
       return (int) data[3].get(0);

    }

 /*
 Get the seats connected to the ReservationIDs.
 */
    public int getSeat(int reservationid) {
        ArrayList[] data = database.getFromDatabase("SELECT * FROM reservations WHERE ReservationID =" +reservationid, "reservations");
        System.out.println(data[4].get(0));
        return (int) data[4].get(0);
    }



/*
Adds all the names from the reservations to the array list "names".
 */
    public ArrayList listNames() {
        ArrayList resIDs = getReservationID();
        ArrayList names = new ArrayList();
        for(int i = 0; i < resIDs.size(); i++) {
            //names.add(getPersonName(getPersonID((int) resIDs.get(i))));
            names.add(getPersonName(i));
        }
        System.out.println("Names: " + names);
        return names;
    }

    /*
    Adds all the phonenumbers from the reservations to the array list "phonenumbers".
     */
   public ArrayList listPhoneNumbers() {
        ArrayList resIDs = getReservationID();
        ArrayList phonenumbers = new ArrayList();
       for(int i = 0; i < resIDs.size(); i++) {
           //phonenumbers.add(getPhoneNumber(getPersonID((int) resIDs.get(i))));
           phonenumbers.add(getPhoneNumber(i));
       }
       System.out.println("Phonenumbers: " + phonenumbers);
       return phonenumbers;
    }

    /*
    Adds all the movie titles from the shows in reservations to the array list "shows".
     */

    public ArrayList listMovieTitles() {
        ArrayList resIDs = getReservationID();
        ArrayList shows = new ArrayList();
        for(int i = 0; i < resIDs.size(); i++) {
            shows.add(getMovieTitle(i));
        }
        System.out.println("Shows: " + shows);
        return shows;
    }

    public ArrayList listDates() {
        ArrayList resIDs = getReservationID();
        ArrayList dates = new ArrayList();
        for(int i = 0; i < resIDs.size(); i++) {
            dates.add(getDate(i));
        }
        System.out.println("Dates: " + dates);
        return dates;
    }


    public ArrayList listTimes() {
        ArrayList resIDs = getReservationID();
        ArrayList times = new ArrayList();
        for(int i = 0; i < resIDs.size(); i++) {
            times.add(getTime(i));
        }
        System.out.println("Times: " + times);
        return times;
    }

    public ArrayList listTheaterNumber() {
        ArrayList resIDs = getReservationID();
        ArrayList theaternumber = new ArrayList();
        for(int i = 0; i < resIDs.size(); i++) {
            theaternumber.add(getTheaterNumber(i));
        }
        System.out.print("Theater: " + theaternumber);
        return theaternumber;
    }
 /*
Adds all row numbers from reservations to the array list "shows".
 */
    public ArrayList listRows() {
        ArrayList resIDs = getReservationID();
        ArrayList rows = new ArrayList();
        for (int i = 0; i < resIDs.size(); i++) {
            rows.add(getRow(i));
        }
        System.out.println("Rows: " + rows);
        return rows;
    }

/*
Adds all seat numbers from reservations to the array list "shows".
*/
    public ArrayList listSeats() {
        ArrayList resIDs = getReservationID();
        ArrayList seats = new ArrayList();
        for (int i = 0; i < resIDs.size(); i++) {
            seats.add(getSeat(i));
        }
        System.out.println("Seats: " + seats);
        return seats;
    }

    public static void main(String[] args) {

        Change change = new Change();
        change.listNames();
        //change.listMovieTitles();
        //change.listPhoneNumbers();
        //change.listDates();
        //change.listTimes();
        //change.listRows();
        //change.listSeats();
        //change.listTheaterNumber();

    }


}