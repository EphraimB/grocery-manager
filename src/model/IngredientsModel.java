package model;

/**
 *
 * IngredientsModel.java
 *
 * Author: Ephraim Becker
 *
 * A model for the ingredients table
 */
public class IngredientsModel {

    // Class fields
    private int id;
    private int recipeId;
    private String ingredients;
    private double quantity;
    private Unit units;

    /**
     * Constructor
     *
     * @param id The id
     * @param recipeId The id of the recipe
     * @param ingredients The ingredient
     * @param quantity The quantity
     * @param units The unit
     */
    public IngredientsModel(int id, int recipeId, String ingredients, double quantity, Unit units) {
        this.id = id;
        this.recipeId = recipeId;
        this.ingredients = ingredients;
        this.quantity = quantity;
        this.units = units;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public Unit getUnits() {
        return this.units;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    // Setters
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setUnits(Unit units) {
        this.units = units;
    }
}
