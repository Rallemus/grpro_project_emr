package project;

import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

import static org.junit.Assert.*;

public class DatabaseLoadTest {

    @Test
    public void testGetFromDatabase() {
        DatabaseLoad database = new DatabaseLoad();
        ArrayList[] data;

        data = database.getFromDatabase("SELECT * FROM person","person");
        String phone = (String) data[1].get(1);
        System.out.println(phone);
        assertEquals(phone, "+4557623987");

        data = database.getFromDatabase("SELECT * FROM reservations", "reservations");
        int showID = (int) data[1].get(1);
        System.out.println(showID);
        assertEquals(showID, 2);


        data = database.getFromDatabase("SELECT * FROM shows", "shows");
        Date date = (Date) data[1].get(1);
        System.out.println("Date: " + date);
        assertEquals(date, new Date(2014-1900, 12-1, 9));

        Time time = (Time) data[2].get(1);
        System.out.println("Time: " + time);
        assertEquals(time, new Time(20, 30, 00));


        data = database.getFromDatabase("SELECT * FROM theater", "theater");
        int theaterNumber = (int) data[0].get(10);
        System.out.println(theaterNumber);
        assertEquals(theaterNumber, 1);

    }

}