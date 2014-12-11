package project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.model.Change;

import java.io.IOException;


public class changeview extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        showCinemaView(primaryStage);
    }

    public void showCinemaView(Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/change.fxml"));
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