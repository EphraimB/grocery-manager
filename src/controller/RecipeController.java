package controller;

import javax.swing.JOptionPane;

import model.RecipeListModel;
import model.RecipeModel;
import view.MenuBar;

public class RecipeController {

    private final RecipeListModel recipeListModel;
    private RecipeModel selectedRecipe;

    private int id;

    public RecipeController(MenuBar menuBar, RecipeListModel recipeListModel) {
        this.recipeListModel = recipeListModel;

        menuBar.getAddRecipe().addActionListener(event -> addRecipe());
        menuBar.getRemoveRecipe().addActionListener(event -> removeRecipe());
    }

    public void setSelectedRecipe(RecipeModel recipe) {
        selectedRecipe = recipe;
    }

    private void addRecipe() {
        String item = JOptionPane.showInputDialog("Enter the name of the new recipe.");

        // Adds the item to the model
        if (item != null && !item.trim().isEmpty()) {
            RecipeModel recipe = new RecipeModel(id++, item.trim());

            recipeListModel.addElement(recipe);
        }
    }

    private void removeRecipe() {
        if (selectedRecipe != null) {
            recipeListModel.removeRecipe(selectedRecipe.getId());
            selectedRecipe = null;
        }
    }

    public RecipeListModel getRecipeListModel() {
        return recipeListModel;
    }
}
