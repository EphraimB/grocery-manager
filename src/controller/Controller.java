package src.controller;

import java.util.ArrayList;
import java.util.List;

import src.model.RecipeModel;
import src.tableModel.RecipeTableModel;
import src.view.MenuBar;

public class Controller {

    private final List<RecipeModel> recipes = new ArrayList<>();

    private final RecipeTableModel recipeTableModel = new RecipeTableModel(recipes);

    public Controller(MenuBar menuBar) {
        menuBar.getAddItem().addActionListener(event -> addRecipe());
    }

    private void addRecipe() {
        RecipeModel recipe = new RecipeModel(0, "", 0.0, "");
        recipeTableModel.addRecipe(recipe);
    }

    public RecipeTableModel getRecipeTableModel() {
        return recipeTableModel;
    }
}
