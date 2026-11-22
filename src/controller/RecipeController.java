package controller;

import javax.swing.JOptionPane;

import model.RecipeListModel;
import tableModel.IngredientsTableModel;
import view.MenuBar;

public class RecipeController {

    private final RecipeListModel recipeListModel;

    public RecipeController(MenuBar menuBar, RecipeListModel recipeListModel) {
        this.recipeListModel = recipeListModel;

        menuBar.getAddRecipe().addActionListener(event -> addRecipe());
    }

    private void addRecipe() {
        String item = JOptionPane.showInputDialog("Enter the name of the new item.");

        // Adds the item to the model
        if (item != null && !item.trim().isEmpty()) {
            recipeListModel.add(item);
        }
    }

    public RecipeListModel getRecipeListModel() {
        return recipeListModel;
    }
}
