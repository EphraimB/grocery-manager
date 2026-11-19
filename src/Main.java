package src;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import src.controller.Controller;
import src.view.Header;
import src.view.Stepper;

public class Main {

    public static void main(String[] args) {
        // Create a new frame with a title
        JFrame frame = new JFrame("Grocery manager");

        // Program exits on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Header header = new Header();

        Stepper stepper = new Stepper();

        frame.add(header, BorderLayout.NORTH);
        frame.add(stepper, BorderLayout.CENTER);

        //WeekdaysPanel weekdaysPanel = new WeekdaysPanel();
        Controller controller = new Controller();

        // Sets the dimension for the frame
        frame.pack();

        // Puts window in the center of the screen
        frame.setLocationRelativeTo(null);

        // Makes the frame visible
        frame.setVisible(true);
    }
}
