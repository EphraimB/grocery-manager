package src.view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import src.tableModel.RecipeTableModel;

public class Stepper extends JTabbedPane {

    public Stepper(RecipeTableModel recipeTableModel) {
        addTab("1) Recipes", new RecipePanel(recipeTableModel));
        addTab("2) Meals", new JPanel());
    }
}
