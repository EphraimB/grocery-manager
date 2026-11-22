package model;

public class IngredientsModel {

    private int id;
    private String ingredients;
    private double quantity;
    private Unit units;

    /**
     * Constructor
     *
     * @param id The id
     * @param ingredients The ingredient
     * @param quantity The quantity
     * @param units
     */
    public IngredientsModel(int id, String ingredients, double quantity, Unit units) {
        this.id = id;
        this.ingredients = ingredients;
        this.quantity = quantity;
        this.units = units;
    }

    public int getId() {
        return this.id;
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
