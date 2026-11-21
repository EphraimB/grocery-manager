package src.view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Stepper extends JTabbedPane {

    public Stepper() {
        addTab("1) Recipes", new RecipePanel());
        addTab("2) Meals", new JPanel());
    }
}
