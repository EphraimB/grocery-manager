package src.view;

import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel {

    public Header() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Grocery manager");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(title);

        JLabel subtitle = new JLabel("A weekly grocery manager for people that don't know where to begin");
        add(subtitle);

    }
}
