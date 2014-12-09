package project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import project.model.Todo;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradientBuilder;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import project.model.Seat;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by Maria on 02-12-2014.
 */
public class MainGridTest extends Application {

    @Override
    public void start(Stage primaryStage) {
    GridPane seatsGrid = new GridPane();
        seatsGrid.setPadding(new Insets(5));
        seatsGrid.setHgap(15);
        seatsGrid.setVgap(15);
        seatsGrid.setAlignment(Pos.CENTER);

        final Seat[][] seat = new Seat[5][5];
        int seatsPerRow = seat[0].length;
        for ( int row = 0; row < seat.length; row++) {
            for ( int seatNumber = 0; seatNumber < seat.length; seatNumber++) {
                int seatsLeftInRow = seatsPerRow-seatNumber-1;
                int shownSeatNumber;

                seat[row][seatNumber] = new Seat("");
                seat[row][seatNumber].setPrefSize(35, 35);

                if(row == 0 && seatNumber == 0) {
                    seat[0][0].setIsFree(false);
                }
                if(row == 0 && seatNumber == 1) {
                    seat[0][1].setIsFree(false);
                }
                if(row == 0 && seatNumber == 2) {
                    seat[0][2].setIsFree(false);
                }
                if(row == 4 && seatNumber == 3) {
                    seat[4][3].setIsFree(false);
                }

                if(seat[row][seatNumber].isFree()) {
                    seat[row][seatNumber].setStyle("-fx-background-color: green;");
                    seat[row][seatNumber].setOnMouseEntered(me -> seatsGrid.setCursor(Cursor.HAND));
                    seat[row][seatNumber].setOnMouseExited(me -> seatsGrid.setCursor(Cursor.DEFAULT));
                }
                else {
                    seat[row][seatNumber].setStyle("-fx-background-color: red;");
                    seat[row][seatNumber].setDisable(true);
                }
                seatsGrid.add(seat[row][seatNumber], seatNumber, row + 2);

                final int finalI = row;
                final int finalJ = seatNumber;
                seat[row][seatNumber].setOnMouseClicked(arg0 -> {
                    for ( int i = 0; i < seat.length; i++) {
                        for (int j = 0; j < seat.length; j++) {

                            if(seat[i][j].isFree()) {
                                seat[i][j].setStyle("-fx-background-color: green;");
                            }

                        }
                    }
                    Seat selectedSeat = (Seat)arg0.getSource();
                    selectedSeat.setStyle("-fx-background-color: dodgerblue;");
                    seat[finalI][finalJ+1].setStyle("-fx-background-color: dodgerblue;");
                    seat[finalI][finalJ+2].setStyle("-fx-background-color: dodgerblue;");
                });
            }
        }

        Scene scene = new Scene(seatsGrid);
        primaryStage.setTitle("Grid Pane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
}
    public static void main(String[] args) {
        launch(args);
    }
}

