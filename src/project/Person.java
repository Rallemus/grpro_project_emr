package project;

import java.util.ArrayList;

/**
 * Created by Maria on 25-11-2014.
 */
public class Person {
    private String name;
    private String number;

    /**
     * Creates a Person-object containing their name and number, which the client has to enter.
     * @param name
     * @param number
     */
    public Person(String name, String number)
    {
        this.name = name;
        this.number = number;
    }

    /**
     * Returns the person's name.
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the person's number.
     * @return number
     */
    public String getNumber()
    {
        return number;
    }

    /**
     * Changes the name of the person from the old one to a new one the client enters.
     * @param newName
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Changes the number of the person from the old one to a new one the client enters.
     * @param newNumber
     */
    public void setNumber(String newNumber)
    {
        number = newNumber;
    }

    public int sum(int[] array){
        int count = 0;
        for(int i : array){
            count =+ i;
        }
        return count;
    }

    // this main method is a temporary (crude) test of the DatabaseLoad class

}
