
import javax.swing.SwingUtilities;
import view.Frame;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Frame frame = new Frame();

            // Makes the frame visible
            frame.setVisible(true);
        });
    }
}
