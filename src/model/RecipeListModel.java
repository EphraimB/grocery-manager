package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * RecipeListModel.java
 *
 * Author: Ephraim Becker
 *
 * The recipe list model for the recipes list
 */
public class RecipeListModel extends DefaultListModel<RecipeModel> {

    // Class field
    private final ArrayList<RecipeModel> recipes = new ArrayList<>();

    /**
     * Constructor
     *
     * @param recipeList A list of recipes
     */
    public RecipeListModel(List<RecipeModel> recipeList) {
        super();

        // Loops through the recipe list
        for (RecipeModel recipe : recipeList) {
            // Adds the item to the model
            addElement(recipe);

            // Add the item to the ArrayList
            recipes.add(recipe);
        }
    }

    /**
     * Adds a recipe
     *
     * @param recipe Recipe to add
     */
    public void add(RecipeModel recipe) {
        // Adds the item to the model
        addElement(recipe);

        // Add the item to the ArrayList
        recipes.add(recipe);
    }

    /**
     * Removes the item at the id
     *
     * @param id The id of the item to remove
     */
    public void removeRecipe(int id) {
        // Loops through the index
        for (int i = 0; i < getSize(); i++) {
            // Checks if the id is equaled to the id at the indexed element
            if (getElementAt(i).getId() == id) {
                // Removes the element at the index
                removeElementAt(i);

                // Breaks the loop
                break;
            }
        }
    }

    /**
     * Exposes the row count
     *
     * @return The row count
     */
    public int getRowCount() {
        return recipes.size();
    }
}
