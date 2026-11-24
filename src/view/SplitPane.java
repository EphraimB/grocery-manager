package view;

import controller.RecipeController;
import javax.swing.JSplitPane;
import model.IngredientsTableModel;
import model.RecipeListModel;

/**
 *
 * SplitPane.java
 *
 * Author: Ephraim Becker
 *
 * Master detail split view
 */
public class SplitPane extends JSplitPane {

    // Ingredients panel class field
    private IngredientsPanel ingredientsPanel;

    /**
     * Constructor
     *
     * @param recipeListModel The recipe list model
     * @param ingredientsTableModel The ingredients list model
     * @param recipeController The recipe controller
     */
    public SplitPane(
            RecipeListModel recipeListModel,
            IngredientsTableModel ingredientsTableModel,
            RecipeController recipeController) {

        // Makes it split horizontally
        super(JSplitPane.HORIZONTAL_SPLIT);

        // Initializes a new ingredients panel
        ingredientsPanel = new IngredientsPanel(ingredientsTableModel);

        // Initializes a new recipes panel
        RecipePanel recipePanel = new RecipePanel(
                recipeListModel,
                selectedRecipe -> {
                    recipeController.setSelectedRecipe(selectedRecipe);

                    // Shows a placeholder or an ingredients table depending
                    // on of the recipe is selected
                    if (selectedRecipe == null) {
                        ingredientsPanel.showPlaceholder();
                    } else {
                        ingredientsPanel.showTable();
                    }
                }
        );

        // Sets the left and right components
        setLeftComponent(recipePanel);
        setRightComponent(ingredientsPanel);
    }
}
