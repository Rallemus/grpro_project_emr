package project.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;



/**
 * Created by Elise on 03-12-2014.
 */
public class Change {

    private StringProperty name = new SimpleStringProperty();
    private StringProperty phone = new SimpleStringProperty();
    private StringProperty shows = new SimpleStringProperty();



    public Change(String name, String phone, String shows) {
        this.name.set(name);
        this.phone.set(phone);
        this.shows.set(shows);
    }

    public String getName() {
        return name.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getShows() {
        return shows.get();
    }


}