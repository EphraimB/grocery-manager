package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.IngredientsModel;
import model.IngredientsTableModel;
import model.RecipeModel;
import model.Unit;
import view.MenuBar;
import view.NewIngredientDialog;

/**
 *
 * IngredientController.java
 *
 * Author: Ephraim Becker
 *
 * The controller for the ingredients
 */
public class IngredientController {

    // The selected recipe
    private RecipeModel selectedRecipe;

    // Initialize an ArrayList of ingredients
    private final List<IngredientsModel> ingredients = new ArrayList<>();

    // Initialize the IngredientsTableModel
    private final IngredientsTableModel ingredientsTableModel = new IngredientsTableModel(ingredients);

    /**
     * Constructor
     *
     * @param menuBar The MenuBar component
     * @param frame The JFrame
     */
    public IngredientController(MenuBar menuBar, JFrame frame) {
        // Adds an action listener on the Add Ingredient Menu Item on the Menu Bar
        menuBar.getAddIngredient().addActionListener(event -> addIngredient(frame));
    }

    /**
     * Adds an ingredient to the ingredients JTable
     */
    private void addIngredient(JFrame frame) {
        // Checks if the selected recipe is null
        if (selectedRecipe == null) {
            // If yes, then a message dialog appears
            JOptionPane.showMessageDialog(frame, "Please select a recipe first.");
            return;
        }

        // Initializes the dialog for the new ingredient
        NewIngredientDialog newIngredientDialog = new NewIngredientDialog(frame);

        // Checks if the showDialog's boolean is set to true
        if (newIngredientDialog.showDialog()) {
            // Initializes the ingredients model with the inputs from the dialog
            IngredientsModel ingredientModel = new IngredientsModel(
                    0,
                    selectedRecipe.getId(),
                    newIngredientDialog.getIngredient().getText(),
                    (double) newIngredientDialog.getQuantity().getValue(),
                    (Unit) newIngredientDialog.getUnit().getSelectedItem()
            );

            // Adds the ingredient
            ingredientsTableModel.addIngredient(ingredientModel);
        }
    }

    /**
     * Exposes the ingredients table model
     *
     * @return The Ingredients table model
     */
    public IngredientsTableModel getIngredientsTableModel() {
        return ingredientsTableModel;
    }

    /**
     * Exposes the selected recipe model
     *
     * @param selectedRecipe The selected recipe model
     */
    public void setSelectedRecipe(RecipeModel selectedRecipe) {
        this.selectedRecipe = selectedRecipe;
    }
}
