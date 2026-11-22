package controller;

import javax.swing.JOptionPane;

import listModel.RecipeListModel;
import model.RecipeModel;
import view.MenuBar;
import view.RecipePanel;

public class RecipeController {

    private RecipePanel recipePanel;
    private final RecipeListModel recipeListModel;

    private int id;

    public RecipeController(MenuBar menuBar, RecipeListModel recipeListModel) {
        this.recipeListModel = recipeListModel;

        menuBar.getAddRecipe().addActionListener(event -> addRecipe());
        menuBar.getRemoveRecipe().addActionListener(event -> removeRecipe());
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
        RecipeModel selected = recipePanel.getRecipeList().getSelectedValue();

        if (selected != null) {
            recipeListModel.removeRecipe(selected.getId());
        }
    }

    public RecipeListModel getRecipeListModel() {
        return recipeListModel;
    }
}
