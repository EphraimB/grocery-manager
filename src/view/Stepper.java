package view;

import controller.RecipeController;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import listModel.RecipeListModel;
import tableModel.IngredientsTableModel;

public class Stepper extends JTabbedPane {

    public Stepper(RecipeListModel recipeListModel,
            IngredientsTableModel ingredientsTableModel,
            RecipeController recipeController) {
        addTab("1) Recipes", new SplitPane(recipeListModel,
                ingredientsTableModel,
                recipeController));
        addTab("2) Meals", new JPanel());
    }
}
