package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import tableModel.IngredientsTableModel;

public class Stepper extends JTabbedPane {

    public Stepper(IngredientsTableModel recipeTableModel) {
        addTab("1) Recipes", new SplitPane(recipeTableModel));
        addTab("2) Meals", new JPanel());
    }
}
