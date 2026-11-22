package controller;

import java.util.ArrayList;
import java.util.List;
import model.IngredientsModel;
import tableModel.IngredientsTableModel;
import view.MenuBar;

public class IngredientController {

    private final List<IngredientsModel> ingredients = new ArrayList<>();

    private final IngredientsTableModel ingredientsTableModel = new IngredientsTableModel(ingredients);

    public IngredientController(MenuBar menuBar) {
        menuBar.getAddIngredient().addActionListener(event -> addIngredient());
    }

    private void addIngredient() {
        IngredientsModel recipe = new IngredientsModel(0, "", 0.0, "");
        ingredientsTableModel.addIngredient(recipe);
    }

    public IngredientsTableModel getIngredientsTableModel() {
        return ingredientsTableModel;
    }
}
