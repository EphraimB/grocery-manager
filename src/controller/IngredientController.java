package controller;

import java.util.ArrayList;
import java.util.List;
import model.IngredientsModel;
import model.IngredientsTableModel;
import model.Unit;
import view.MenuBar;

public class IngredientController {

    private final List<IngredientsModel> ingredients = new ArrayList<>();

    private final IngredientsTableModel ingredientsTableModel = new IngredientsTableModel(ingredients);

    public IngredientController(MenuBar menuBar) {
        menuBar.getAddIngredient().addActionListener(event -> addIngredient());
    }

    private void addIngredient() {
        IngredientsModel ingredientModel = new IngredientsModel(0, "", 0.0, Unit.NONE);
        ingredientsTableModel.addIngredient(ingredientModel);
    }

    public IngredientsTableModel getIngredientsTableModel() {
        return ingredientsTableModel;
    }
}
