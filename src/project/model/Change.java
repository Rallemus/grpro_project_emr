package project.model;
import project.DatabaseLoad;

import java.util.ArrayList;


/**
 * Created by Elise on 03-12-2014.
 */
public class Change {

    private DatabaseLoad database = new DatabaseLoad();


/*    public Change(String name, String phone, String shows) {

    }
*/

/*
 Retrieve the NameIDs from the reservations in the database.
*/
    public ArrayList getPersonID() {
        ArrayList[] data = database.getFromDatabase("SELECT * FROM reservations", "reservations"); // fills an arraylist with data from the database table "reservations".
        return data[1]; //1 refers to the second column in the table "reservations" which is NameID.
    }

/*
Retrieve the ShowIDs from the reservations in the database
 */

    public ArrayList getShowID() {
        ArrayList[] data = database.getFromDatabase("SELECT * FROM reservations", "reservations");
        //fills an arraylist with data from the database table "reservations".
        System.out.println(data[2]);
        return data[2]; //2 refers to the third column in the table "reservations" which is ShowID.

    }

    public ArrayList getReservationID() {
        ArrayList[] data = database.getFromDatabase("SELECT DISTINCT ReservationID FROM reservations", "reservations");
        //fills an arraylist with data from the row ReservationID in the table "reservations".
        System.out.println(data[0]);
        return data[0]; //0 refers to the first column in the table "reservations" which is ReservationsID.
    }

/*
    Get the names connected to the NameIDs (in the reservations).
 */
    public ArrayList getPersonName()  {
        ArrayList idList = getPersonID();
        String names = "";
        int i;
        for(i = 0; i < idList.size()-1; i++) {
            names = names + idList.get(i) + ", ";
        }
        names = names + idList.get(i);
        ArrayList[] data = database.getFromDatabase("SELECT * FROM person WHERE PersonID IN (" + names + ")", "person");
       // ArrayList persons = data[0];
        System.out.println(data[0]); //0 refers to the first column in the table "persons" which is Name.
        return data[0];
    }


/*
    Get the PhoneNumber connected to the PersonIDs (in the reservations).
 */
    public ArrayList getPhone() {
        ArrayList phoneList = getPersonID();
        String phonenumbers = "";
        int i;
        for(i=0; i < phoneList.size()-1; i++) {
            phonenumbers = phonenumbers + phoneList.get(i) + ", ";
        }

        phonenumbers = phonenumbers + phoneList.get(i);
        ArrayList[] data = database.getFromDatabase("SELECT * FROM person WHERE PersonID IN (" + phonenumbers + ")", "person");
        //ArrayList phonenumbers = data[1];
        System.out.println(data[1]);
        return data[1]; // 1 refers to the second column in the table 'persons' which is PhoneNumber.
    }

    public ArrayList getShow() {
        ArrayList showList = getShowID();
        String shows = "";
        int i;
        for(i=0; i < showList.size()-1; i++) {
            shows = shows + showList.get(i) + ", ";
        }
        shows = shows + showList.get(i);
        System.out.println(shows);
        ArrayList[] data = database.getFromDatabase("SELECT * FROM shows WHERE ShowID in (" + shows + ")", "shows");
        System.out.println(data[0]);
        return data[0]; //0 refers to the second column in the table "shows" which is ShowTitle.
    }

   /* public ArrayList getRow() {
        ArrayList[] data = database.getFromDatabase("SELECT DISTINCT Row FROM reservations WHERE ReservationID IN reservations")
    }

*/
  /*  public ArrayList getSeats() {
        ArrayList seatList =
    }


*/
    public static void main(String[] args) {

        Change change = new Change();
        //change.getPersonName();
        change.getReservationID();
        //change.getPhone();
        //change.getShow();

    }






}