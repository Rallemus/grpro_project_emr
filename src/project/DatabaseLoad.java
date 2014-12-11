package project;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by Rasmus on 02-12-2014.
 */
public class DatabaseLoad {

    private ArrayList[] returnResult = new ArrayList[] {new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()};

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql.itu.dk/BBooking";
    // "jdbc:mysql://localhost3306/cinema"

    //  Database credentials
    static final String USER = "emr";
    static final String PASS = "emr123456";


    public ArrayList[] getFromDatabase(String sql, String table) {
        returnResult = new ArrayList[] {new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()};
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName (JDBC_DRIVER);


            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            //while(rs.next()) {
            switch (table) {
                case "person": {
                    while(rs.next()) {
                        String name = rs.getString("Name");
                        String phone = rs.getString("PhoneNumber");
                        returnResult[0].add(name);
                        returnResult[1].add(phone);
                    }
                    break;
                }
                case "reservations": {
                    while (rs.next()) {
                        int reservationID = rs.getInt("ReservationID");
                        int personID = rs.getInt("PersonID");
                        int showID = rs.getInt("ShowID");
                        int row = rs.getInt("Row");
                        int seat = rs.getInt("Seat");
                        returnResult[0].add(reservationID);
                        returnResult[1].add(personID);
                        returnResult[2].add(showID);
                        returnResult[3].add(row);
                        returnResult[4].add(seat);
                    }
                    break;
                }

                case "name": {
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        returnResult[0].add(name);
                    }
                    break;
                }

                case "phone": {
                    while (rs.next()) {
                        String phone = rs.getString("PhoneNumber");
                        returnResult[0].add(phone);
                    }
                    break;
                }

                case "reservationID": {
                    while (rs.next()) {
                        String reservationID = rs.getString("ReservationID");
                        returnResult[0].add(reservationID);
                    }
                    break;
                }

                case "personID": {
                    while (rs.next()) {
                        String personID = rs.getString("PersonID");
                        returnResult[0].add(personID);
                    }
                    break;
                }

                case "showID": {
                        while (rs.next()) {
                            String showID = rs.getString("ShowID");
                            returnResult[0].add(showID);
                        }
                        break;
                    }

                case "row": {
                    while (rs.next()) {
                        String row = rs.getString("Row");
                        returnResult[0].add(row);
                    }
                    break;
                }

                case "seat": {
                    while (rs.next()) {
                        String seat = rs.getString("Seat");
                        returnResult[0].add(seat);
                    }
                    break;
                }


                case "shows": {
                    while (rs.next()) {
                        String showTitle = rs.getString("ShowTitle");
                        Date showDate = rs.getDate("ShowDate");
                        Time showTime = rs.getTime("ShowTime");
                        int theaterNumber = rs.getInt("Theater");
                        returnResult[0].add(showTitle);
                        returnResult[1].add(showDate);
                        returnResult[2].add(showTime);
                        returnResult[3].add(theaterNumber);
                    }
                    break;
                }
                case "theater": {
                    while (rs.next()) {
                        int theaterNumber = rs.getInt("Theater");
                        int theaterRow = rs.getInt("Row");
                        int theaterSeat = rs.getInt("Seat");
                        returnResult[0].add(theaterNumber);
                        returnResult[1].add(theaterRow);
                        returnResult[2].add(theaterSeat);
                    }
                    break;
                }
                case "showTitle": {
                    while (rs.next()) {
                        String showTitle = rs.getString("ShowTitle");
                        returnResult[0].add(showTitle);
                    }
                    break;
                }
                case "showDate": {
                    while (rs.next()) {
                        Date showDate = rs.getDate("ShowDate");
                        returnResult[0].add(showDate);
                    }
                    break;
                }
                case "showTime": {
                    while (rs.next()) {
                        Time showTime = rs.getTime("ShowTime");
                        returnResult[0].add(showTime);
                    }
                    break;
                }
            }


            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

        return returnResult;
    }




}