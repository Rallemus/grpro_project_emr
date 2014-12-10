package project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by Maria on 02-12-2014.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        showCinemaView(primaryStage);
    }

    public void showCinemaView(Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/cinema.fxml"));
            Parent cinemaView = loader.load();
            stage.setTitle("Biograf");
            stage.setScene(new Scene(cinemaView, 700, 500));
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace(); //show dialog
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
