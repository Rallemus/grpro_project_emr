package project.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Rasmus on 01-12-2014.
 */
public class Todo {
    private StringProperty task = new SimpleStringProperty();
    private StringProperty project = new SimpleStringProperty();
    private ObjectProperty<LocalDate> dueDate = new SimpleObjectProperty<LocalDate>();
    public static final DateTimeFormatter DueDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Todo(String task, String project, LocalDate dueDate) {
        this.task.set(task);
        this.project.set(project);
        this.dueDate.set(dueDate);
    }

    public String getTask() {
        return task.get();
    }

    public void setTask(String task) {
        this.task.set(task);
    }

    public StringProperty taskProperty() {
        return task;
    }


    public String getProject() {
        return project.get();
    }

    public void setProject(String project) {
        this.project.set(project);
    }

    public StringProperty projectProperty() {
        return project;
    }


    public LocalDate getDueDate() {
        return dueDate.get();
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate.set(dueDate);
    }

    public ObjectProperty<LocalDate> dueDateProperty() {
        return dueDate;
    }

}
