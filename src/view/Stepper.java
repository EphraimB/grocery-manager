package src.view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Stepper extends JTabbedPane {

    public Stepper() {
        Recipes recipes = new Recipes();

        addTab("1) Recipes", recipes);
        addTab("2) Meals", new JPanel());
    }
}
