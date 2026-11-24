
import javax.swing.SwingUtilities;
import view.Frame;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Creates the frame instance
            Frame frame = new Frame();

            // Makes the frame visible
            frame.setVisible(true);
        });
    }
}
