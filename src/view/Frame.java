package src.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

    public Frame() {
        super("Grocery manager");

        Header header = new Header();
        Stepper stepper = new Stepper();
        MenuBar menuBar = new MenuBar();

        add(menuBar, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new BorderLayout());

        contentPanel.add(header, BorderLayout.NORTH);
        contentPanel.add(stepper, BorderLayout.CENTER);
        add(contentPanel);

        // Program exits on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets the dimension for the frame
        pack();

        // Puts window in the center of the screen
        setLocationRelativeTo(null);
    }
}
