package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * RecipeModel.java
 *
 * Author: Ephraim Becker
 *
 * The model for the recipes list
 */
public class RecipeModel {

    // Class fields
    private final int id;
    private final String name;
    private final List<IngredientsModel> ingredients = new ArrayList<>();

    /**
     * Constructor
     *
     * @param id The recipe id
     * @param name The name of the recipe
     */
    public RecipeModel(int id, String name) {
        // Sets the class fields the the specified parameters
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Adds the ingredient to the ingredients
     *
     * @param ingredient The ingredient to be added
     */
    public void addIngredient(IngredientsModel ingredient) {
        ingredients.add(ingredient);
    }

    /**
     * Exposes the ingredients
     *
     * @return The list of ingredients
     */
    public List<IngredientsModel> getIngredients() {
        return ingredients;
    }
}
