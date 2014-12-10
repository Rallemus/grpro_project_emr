package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.controller.ReservationController;
import project.model.Reservation;

import java.io.IOException;

/**
 * Created by Rasmus on 07-12-2014.
 */
public class ReservationMain extends Application {

    public void showReservationView(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/reservation.fxml"));
            Parent reservationView = loader.load();
            ReservationController controller = loader.getController();
            controller.initialize();
            primaryStage.setTitle("Reservation");
            primaryStage.setScene(new Scene(reservationView, 500, 500));

            /*Get the controller from the fx:controller attribute of our FXML*/

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace(); //Show a dialog or something... ?
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        showReservationView(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
