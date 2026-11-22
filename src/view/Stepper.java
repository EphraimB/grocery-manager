package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import listModel.RecipeListModel;
import tableModel.IngredientsTableModel;

public class Stepper extends JTabbedPane {

    public Stepper(RecipeListModel recipeListModel, IngredientsTableModel recipeTableModel) {
        addTab("1) Recipes", new SplitPane(recipeListModel, recipeTableModel));
        addTab("2) Meals", new JPanel());
    }
}
