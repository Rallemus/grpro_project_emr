import java.sql.*;
import java.util.ArrayList;


/**
 * Created by Rasmus on 02-12-2014.
 */
public class DatabaseLoad {

        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/cinema";
        // "jdbc:mysql://localhost3306/cinema"

        //  Database credentials
        static final String USER = "root";
        static final String PASS = "123456";


    public ArrayList[] getFromDatabase(String[] columns, String table) {
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
            String values = "";
            int count = 0;
            for(String value : columns) {
                if(count < columns.length) {
                    values = values + value + ", ";
                }
                values = values + value;
                count++;
            }
            values = "Name, PhoneNumber";
            System.out.print(values);
            sql = "SELECT " + values + " FROM " + table;
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            ArrayList[] result = new ArrayList[4];
            while(rs.next()){
                ArrayList<ArrayList> allValues;
                switch (table) {
                    case "person":
                        String name = rs.getString("Name");
                        String phone = rs.getString("PhoneNumber");
                        result[0].add(name);
                        result[1].add(phone);
                        break;
                    case "reservations":
                        int personID = rs.getInt("PersonID");
                        int showID = rs.getInt("ShowID");
                        String row = rs.getString("Row");
                        String seat= rs.getString("Seat");
                        result[0].add(personID);
                        result[1].add(showID);
                        result[2].add(row);
                        result[3].add(seat);
                        break;
                    case "shows":
                        String showTitle = rs.getString("ShowTitle");
                        int showDate = rs.getInt("ShowDate");
                        int showTime = rs.getInt("ShowTime");
                        result[0].add(showTitle);
                        result[1].add(showDate);
                        result[2].add(showTime);
                        break;
                    case "theater":
                        int theaterNumber = rs.getInt("Theater");
                        int theaterRow = rs.getInt("Row");
                        int theaterSeat = rs.getInt("Seat");
                        result[0].add(theaterNumber);
                        result[1].add(theaterRow);
                        result[2].add(theaterSeat);
                        break;
                }

            return result;

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

        return new ArrayList[1];
    }
}
