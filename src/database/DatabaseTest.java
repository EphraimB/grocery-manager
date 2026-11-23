package database;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseTest {

    public static void main(String[] args) {
        // Create DatabaseManager
        DatabaseManager databaseManager = new DatabaseManager();

        // Open connection
        try (Connection conn = databaseManager.getConnection()) {
            System.out.println("Connection successful: " + !conn.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
