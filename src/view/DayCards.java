package src.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DayCards extends JPanel {

    public DayCards(String day) {
        JLabel dayLabel = new JLabel(day);

        add(dayLabel);
    }

}
