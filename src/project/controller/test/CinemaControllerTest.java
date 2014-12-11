package project.controller.test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import project.controller.CinemaController;
import project.model.Cinema;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyCollection;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CinemaControllerTest {

    private CinemaController controller;

    @Before
    public void setUp() throws Exception {
        Cinema cinema = mock(Cinema.class);
        when(cinema.getDate(anyString(), anyString())).thenReturn(FXCollections.observableArrayList());
        controller = new CinemaController();
        controller.setCinema(cinema);
     //   verify(cinema).getSelectedshows();
    }

    @Test
    public void testInitialize() throws Exception {

    }

    @Test
    public void testGetButton() throws Exception {

    }

    @Test
    public void testButtonvisible() throws Exception {

    }
}