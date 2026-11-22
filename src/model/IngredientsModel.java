package model;

public class IngredientsModel {

    private int id;
    private String ingredients, units;
    private double quantity;

    public IngredientsModel(int id, String ingredients, double quantity, String units) {
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

    public String getUnits() {
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

    public void setUnits(String units) {
        this.units = units;
    }
}
