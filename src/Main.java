
import view.Frame;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Frame frame = new Frame();

            //WeekdaysPanel weekdaysPanel = new WeekdaysPanel();
            // Makes the frame visible
            frame.setVisible(true);
        });
    }
}
