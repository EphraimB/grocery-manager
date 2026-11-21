package src.model;

public class Recipe {

    private int id;
    private String ingredients, units;
    private double quantity;

    public Recipe(int id, String ingredients, String units, double quantity) {
        this.id = id;
        this.ingredients = ingredients;
        this.units = units;
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public String getUnits() {
        return this.units;
    }

    public double getQuantity() {
        return this.quantity;
    }
}
