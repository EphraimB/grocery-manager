package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.IngredientsModel;
import model.IngredientsTableModel;
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

    NewIngredientDialog newIngredientDialog;

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
        newIngredientDialog = new NewIngredientDialog(frame);

        newIngredientDialog.getOptionPane().addPropertyChangeListener(event -> {
            if (event.getSource() == newIngredientDialog.getOptionPane()
                    && JOptionPane.VALUE_PROPERTY.equals(event.getPropertyName())) {
                newIngredientDialog.closeDialog();
            }
        });
        // Adds an action listener on the Add Ingredient Menu Item on the Menu Bar
        menuBar.getAddIngredient().addActionListener(event -> addIngredient());
    }

    /**
     * Adds an ingredient to the ingredients JTable
     */
    private void addIngredient() {
        if (newIngredientDialog.showDialog()) {
            // Initializes a new IngredientsModel
            IngredientsModel ingredientModel = new IngredientsModel(0, newIngredientDialog.getIngredient().getText(), (double) newIngredientDialog.getQuantity().getValue(), (Unit) newIngredientDialog.getUnit().getSelectedItem());
            // Adds the ingredient to the ingredients JTable
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
}
