package project.model;

/**
 * Created by Elise on 27-11-2014.
 */
public class Theater {
    private int seats;
    private int rows;
    private int total_seats;
    private int available_seats;
    private int reserved_seats;


    /**
     * The constructor
     */
    public Theater() {

    }

    /**
     * @return returns the total number of seats in the given theater.
     */
    public int getTotal_seats() {
        return total_seats;
    }
}
