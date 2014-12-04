package project;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by Rasmus on 02-12-2014.
 */
public class DatabaseLoad {

    private ArrayList[] returnResult = new ArrayList[] {new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()};

        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/cinema";
        // "jdbc:mysql://localhost3306/cinema"

        //  Database credentials
        static final String USER = "root";
        static final String PASS = "123456";


    public ArrayList[] getFromDatabase(String table) {
        returnResult = new ArrayList[] {new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()};
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
            String sql;

            sql = "SELECT * FROM " + table;
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
                            int personID = rs.getInt("PersonID");
                            int showID = rs.getInt("ShowID");
                            String row = rs.getString("Row");
                            String seat = rs.getString("Seat");
                            returnResult[0].add(personID);
                            returnResult[1].add(showID);
                            returnResult[2].add(row);
                            returnResult[3].add(seat);
                        }
                        break;
                    }
                    case "shows": {
                        while (rs.next()) {
                            String showTitle = rs.getString("ShowTitle");
                            Date showDate = rs.getDate("ShowDate");
                            Time showTime = rs.getTime("ShowTime");
                            returnResult[0].add(showTitle);
                            returnResult[1].add(showDate);
                            returnResult[2].add(showTime);
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
