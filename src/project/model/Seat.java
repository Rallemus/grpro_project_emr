package project.model;

import javafx.scene.control.Button;

/**
 * Created by Rasmus on 06-12-2014.
 */
public class Seat extends Button {

    private boolean isFree;

    public Seat(String text) {
        super(text);
        isFree = true;
    }


    public boolean isFree() {
        return isFree;
    }

    public void setIsFree(boolean value) {
        isFree = value;
    }
}
