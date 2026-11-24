package model;

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
}
