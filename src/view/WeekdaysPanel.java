package src.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WeekdaysPanel extends JPanel {

    private static JButton addFoodButton = null;

    public WeekdaysPanel() {
        // Sets an array with the days of the week
        super(new GridLayout(7, 1, 1, 1));

        String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};

        // Loop through the days of the week
        for (String weekday : weekdays) {
            DayCards dayCards = new DayCards(weekday);
            addFoodButton = new JButton("+ Add food");

            add(dayCards);
            add(addFoodButton);
        }
    }

    public JButton getAddFoodButton() {
        return addFoodButton;
    }
}
