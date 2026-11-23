package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

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
     * Removes the item at the id
     *
     * @param id The id of the item to remove
     */
    public void removeRecipe(int id) {
        for (int i = 0; i < getSize(); i++) {
            if (getElementAt(i).getId() == id) {
                removeElementAt(i);
                break;
            }
        }
    }

    public int getRowCount() {
        return recipes.size();
    }
}
