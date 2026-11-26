package view;

import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * Header.java
 *
 * Author: Ephraim Becker
 *
 * The header component
 */
public class Header extends JPanel {

    public Header() {
        // Sets the layout to a box layout going top to bottom
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Adds a title JLabel
        JLabel title = new JLabel("Grocery manager");

        // Sets a font for the title JLabel
        title.setFont(new Font("Tahoma", Font.BOLD, 18));

        // Centers the title
        title.setAlignmentX(CENTER_ALIGNMENT);

        // Adds the title to the JFrame
        add(title);

        // Adds a subtitle JLabel
        JLabel subtitle = new JLabel("A weekly grocery manager for people who don't know where to begin");

        // Centers the subtitle
        subtitle.setAlignmentX(CENTER_ALIGNMENT);

        // Adds the subtitle
        add(subtitle);
    }
}
