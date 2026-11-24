
import database.DatabaseManager;
import java.sql.SQLException;
import javax.swing.SwingUtilities;
import view.Frame;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DatabaseManager databaseManager = new DatabaseManager();

            try {
                databaseManager.initializeDatabase();

                Frame frame = new Frame();

                // Makes the frame visible
                frame.setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
