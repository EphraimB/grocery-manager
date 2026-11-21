package src;

import java.awt.BorderLayout;
import src.view.Frame;

import javax.swing.JFrame;
import src.controller.Controller;
import src.view.Header;
import src.view.MenuBar;
import src.view.Stepper;

public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame();

        //WeekdaysPanel weekdaysPanel = new WeekdaysPanel();
        Controller controller = new Controller();

        // Makes the frame visible
        frame.setVisible(true);
    }
}
