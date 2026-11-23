package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private Connection conn = null;

    public Connection getConnection() throws SQLException {

        conn = DriverManager.getConnection("jdbc:hsqldb:file:database/grocery");

        System.out.println("Connected to database");
        return conn;
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}
