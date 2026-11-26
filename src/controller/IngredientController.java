package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
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

    private RecipeModel selectedRecipe;

    // Initialize an ArrayList of ingredients
    private final List<IngredientsModel> ingredients = new ArrayList<>();

    // Initialize the IngredientsTableModel
    private final IngredientsTableModel ingredientsTableModel = new IngredientsTableModel(ingredients);

    /**
     * Constructor
     *
     * @param menuBar The MenuBar component
     */
    public IngredientController(MenuBar menuBar, JFrame frame) {
        // Adds an action listener on the Add Ingredient Menu Item on the Menu Bar
        menuBar.getAddIngredient().addActionListener(event -> addIngredient(frame));
    }

    /**
     * Adds an ingredient to the ingredients JTable
     */
    private void addIngredient(JFrame frame) {
        NewIngredientDialog newIngredientDialog
                = new NewIngredientDialog(frame);

        if (newIngredientDialog.showDialog()) {

            IngredientsModel ingredientModel = new IngredientsModel(
                    0,
                    selectedRecipe.getId(),
                    newIngredientDialog.getIngredient().getText(),
                    (double) newIngredientDialog.getQuantity().getValue(),
                    (Unit) newIngredientDialog.getUnit().getSelectedItem()
            );

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

    public void setSelectedRecipe(RecipeModel selectedRecipe) {
        this.selectedRecipe = selectedRecipe;
    }
}
