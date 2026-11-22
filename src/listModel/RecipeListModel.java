package listModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import model.RecipeModel;

public class RecipeListModel extends DefaultListModel<RecipeModel> {

    private final ArrayList<RecipeModel> recipes = new ArrayList<>();

    /**
     * Constructor
     *
     * @param recipeList A list of recipes
     */
    public RecipeListModel(List<RecipeModel> recipeList) {
        super();

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
