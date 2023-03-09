package oop.persistence;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/storage";
    private static final String USER = "root";
    private static final String PASS = "1997marci";

    public static Connection getDatabaseConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        connection = null;
    }
}
