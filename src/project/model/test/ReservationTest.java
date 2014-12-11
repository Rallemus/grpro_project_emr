package project.model.test;

import project.model.Reservation;

import static org.junit.Assert.*;

public class ReservationTest {

    public void testInitializeSeats() {
        Reservation reservation = new Reservation();
        //reservation.initialize();
        assertEquals(reservation.getNumberOfRows(), 7);
        assertEquals(reservation.getNumberOfSeats(), 8);
        assertEquals(reservation.getNumberOfSeatsInARow(), 7*8);

    }

}