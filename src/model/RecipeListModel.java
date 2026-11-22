package model;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class RecipeListModel extends DefaultListModel<String> {

    private final ArrayList<String> recipes = new ArrayList<>();

    /**
     * Constructor
     *
     * @param recipeList A list of recipes
     */
    public RecipeListModel(String... recipeList) {
        super();

        for (String recipe : recipeList) {
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
    public void add(String recipe) {
        // Adds the item to the model
        addElement(recipe);

        // Add the item to the ArrayList
        recipes.add(recipe);
    }

    /**
     *
     * Removes the item
     *
     * @param index The item to remove
     */
    public void removeItem(int index) {
        // Checks if the index is at least 0 and is less than the the total items
        if (index >= 0 && index < getSize()) {
            // Removes the item at the index
            remove(index);
        }
    }
}
