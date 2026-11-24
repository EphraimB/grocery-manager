package view;

import controller.RecipeController;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import model.IngredientsTableModel;
import model.RecipeListModel;

/**
 *
 * Stepper.java
 *
 * Author: Ephraim Becker
 *
 * A tabbed pane to switch between steps
 */
public class Stepper extends JTabbedPane {

    /**
     * Constructor
     *
     * @param recipeListModel The recipe list model
     * @param ingredientsTableModel The ingredients table model
     * @param recipeController The recipes controller
     */
    public Stepper(RecipeListModel recipeListModel,
            IngredientsTableModel ingredientsTableModel,
            RecipeController recipeController) {
        // Adds the recipes tab which shows the recipes and its ingredients
        addTab("Recipes", new SplitPane(recipeListModel,
                ingredientsTableModel,
                recipeController));

        // Adds a meals tab
        addTab("Meals", new JPanel());
    }
}
