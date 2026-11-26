package controller;

import javax.swing.JOptionPane;
import model.RecipeListModel;
import model.RecipeModel;
import view.MenuBar;

/**
 *
 * RecipeController.java
 *
 * Author: Ephraim Becker
 *
 * The controller for the recipes
 */
public class RecipeController {

    // Class fields
    private final RecipeListModel recipeListModel;
    private RecipeModel selectedRecipe;
    private int id = 1;

    /**
     * Constructor
     *
     * @param menuBar MenuBar component
     * @param recipeListModel The recipe list model
     */
    public RecipeController(MenuBar menuBar, RecipeListModel recipeListModel) {
        this.recipeListModel = recipeListModel;

        // Adds action listeners on the Add Recipe and Remove Recipe Menu Items
        menuBar.getAddRecipe().addActionListener(event -> addRecipe());
        menuBar.getRemoveRecipe().addActionListener(event -> removeRecipe());
    }

    /**
     * Sets the selected recipe to the model
     *
     * @param recipe The recipe model
     */
    public void setSelectedRecipe(RecipeModel selectedRecipe) {
        this.selectedRecipe = selectedRecipe;
    }

    /**
     * Adds the recipe to the model
     */
    private void addRecipe() {
        // Shows a dialog to enter a new recipe
        String item = JOptionPane.showInputDialog("Enter the name of the new recipe.");

        // Adds the item to the model
        if (item != null && !item.trim().isEmpty()) {
            // Initializes a new recipe model with an incremented id and the item
            RecipeModel recipeModel = new RecipeModel(id++, item.trim());

            // Adds the element to the recipe list model
            recipeListModel.addElement(recipeModel);
        }
    }

    /**
     * Removes the recipe from the model
     */
    private void removeRecipe() {
        // Checks if the selected recipe isn't empty
        if (selectedRecipe != null) {
            // Removes the recipe from the list model
            recipeListModel.removeRecipe(selectedRecipe.getId());

            // Nullifies the selected recipe
            selectedRecipe = null;
        }
    }

    /**
     * Gets the recipe list model
     *
     * @return The recipe list model
     */
    public RecipeListModel getRecipeListModel() {
        return recipeListModel;
    }
}
