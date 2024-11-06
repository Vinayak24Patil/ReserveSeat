package AirlineManagementSystem;

import java.sql.*;

public class Cone {

    Connection c;
    Statement s;

    public Cone() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC driver
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "Vinayak@24");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Return the existing connection
    public Connection getConnection() {
        return c;
    }

    // Prepare and return a PreparedStatement
    public PreparedStatement prepareStatement(String query) throws  SQLException {
        return c.prepareStatement(query);
    }
}

