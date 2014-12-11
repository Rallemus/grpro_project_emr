package project.model;

import javafx.scene.control.Button;

/**
 * Created by Rasmus on 06-12-2014.
 */
public class Seat extends Button {

    private boolean isFree;
    private boolean isSelected;

    public Seat(String text) {
        super(text);
        isFree = true;
        isSelected = false;
    }


    public boolean isFree() {
        return isFree;
    }

    public void setIsFree(boolean value) {
        isFree = value;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean value) {
        isSelected = value;
    }
}
