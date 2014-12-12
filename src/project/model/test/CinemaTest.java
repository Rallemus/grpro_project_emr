package project.model.test;
/*
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import project.DatabaseLoad;
import project.controller.CinemaController;
import project.model.Cinema;
import static org.junit.Assert.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CinemaTest {

  /*  @Before
    public void setUp() throws Exception {
        Cinema cinema = mock(Cinema.class);
        try {
            ResultSet e = (ResultSet)Mockito.mock(ResultSet.class);
            Mockito.when(e.getString("ShowTitle")).thenReturn("Interstellar", new String[]{"Hobbitten", "Terkel i knibe"});
            Mockito.when(e.getString("ShowDate")).thenReturn("20141212", new String[]{"20140816", "20141211"});
            Mockito.when(e.getString("ShowTime")).thenReturn("200000", new String[]{"153000", "080000"});
            Mockito.when(Boolean.valueOf(e.next())).thenReturn(Boolean.valueOf(true), new Boolean[]{Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(false)});
            Statement mockStatement = (Statement)Mockito.mock(Statement.class);
            Mockito.when(mockStatement.executeQuery("select * from show")).thenReturn(e);
            Connection mockConnection = (Connection)Mockito.mock(Connection.class);
            Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
            List shows = cinema.getShow("", "");
            ArrayList expectedShows = new ArrayList();
            expectedShows.add("Interstellar");
            expectedShows.add("Hobbitten");
            expectedShows.add("Terkel i knibe");
            ArrayList expectedDates = new ArrayList();
            expectedDates.add("20141212");
            expectedDates.add("20140816");
            expectedDates.add("20141211");
            ArrayList expectedTimes = new ArrayList();
            expectedDates.add("200000");
            expectedDates.add("153000");
            expectedDates.add("080000");

            Assert.assertArrayEquals(expectedShows.toArray(), shows.toArray());
        } catch (SQLException var7) {
            ;
        }        //   verify(cinema).getSelectedshows();

}
    @Test
    public void testMain() throws Exception {

    }
*/

import javafx.collections.ObservableList;
import org.junit.Test;
import project.DatabaseLoad;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import project.model.Cinema;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

import static org.junit.Assert.*;

public class CinemaTest {

    @Test
    public void testGetShow() {
        Cinema cinema = new Cinema();
        ObservableList shows;

        shows = cinema.getShow("", "");
        String title = String.valueOf(shows.toArray()[0]);
        System.out.println(title);
        assertEquals(title, "Hobbitten");
        assertEquals(shows.size(), 3);

        ObservableList shows2;
        shows2 = cinema.getShow("20141224", "");
        String title2 = String.valueOf(shows2.toArray()[0]);
        System.out.println(title2);
        assertEquals(title2, "Hobbitten");
        assertEquals(shows2.size(), 2);

        ObservableList shows3;
        shows3 = cinema.getShow("", "200000");
        String title3 = String.valueOf(shows3.toArray()[0]);
        System.out.println(title3);
        assertEquals(title3, "The Hunger Games: Mockingjay - Part 1");
        assertEquals(shows3.size(), 1); //making sure it only counts the shows within the next 2 weeks

        ObservableList shows4;
        shows4 = cinema.getShow("20141217", "210000");
        String title4 = String.valueOf(shows4.toArray()[0]);
        System.out.println(title4);
        assertEquals(title4, "Hobbitten");
        assertEquals(shows4.size(), 1);

        ObservableList shows5;
        shows5 = cinema.getShow("20150228", "140000");
        assertEquals(shows5.size(), 0);

    }

    @Test
    public void testGetDate() throws Exception {
        Cinema cinema = new Cinema();
        ObservableList dates;

        dates = cinema.getDate("", "");
/*        String date = String.valueOf(dates.toArray()[0]);
        System.out.println(date);
        assertEquals(date, 20141209);
        assertEquals(dates.size(), 17);

        ObservableList shows2;
        shows2 = cinema.getShow("20141224", "");
        String title2 = String.valueOf(shows2.toArray()[0]);
        System.out.println(title2);
        assertEquals(title2, "Hobbitten");
        assertEquals(shows2.size(), 2);

        ObservableList shows3;
        shows3 = cinema.getShow("", "200000");
        String title3 = String.valueOf(shows3.toArray()[0]);
        System.out.println(title3);
        assertEquals(title3, "The Hunger Games: Mockingjay - Part 1");
        assertEquals(shows3.size(), 1); //making sure it only counts the shows within the next 2 weeks

        ObservableList shows4;
        shows4 = cinema.getShow("20141217", "210000");
        String title4 = String.valueOf(shows4.toArray()[0]);
        System.out.println(title4);
        assertEquals(title4, "Hobbitten");
        assertEquals(shows4.size(), 1);

        ObservableList shows5;
        shows5 = cinema.getShow("20150228", "140000");
        assertEquals(shows5.size(), 0);

    }

    @Test
    public void testGetTime() throws Exception {
*/
    }
}