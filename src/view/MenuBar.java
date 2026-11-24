package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * MenuBar.java
 *
 * Author: Ephraim Becker
 *
 * The menu bar
 */
public class MenuBar extends JMenuBar {

    // Class fields
    JMenu fileMenu, editMenu, recipe, ingredient;
    JMenuItem saveMenuItem, closeMenuItem, addIngredient, removeIngredient, addRecipe, removeRecipe;

    /**
     * Constructor
     */
    public MenuBar() {
        // Build the file menu
        fileMenu = new JMenu("File");

        // Add the Save and Close menu items to the file menu
        saveMenuItem = new JMenuItem("Save");
        closeMenuItem = new JMenuItem("Close");

        // Add them to the file menu
        fileMenu.add(saveMenuItem);
        fileMenu.add(closeMenuItem);

        // Add the file menu to the menu bar
        add(fileMenu);

        // Build the edit menu
        editMenu = new JMenu("Edit");

        // Build the Recipe submenu
        recipe = new JMenu("Recipe");

        // Add the Add and Remove recipe to the Recipe submenu
        addRecipe = new JMenuItem("Add Recipe");
        removeRecipe = new JMenuItem("Remove Recipe");

        // Add the menu items to the Recipe submenu
        recipe.add(addRecipe);
        recipe.add(removeRecipe);

        // Build the Ingredient submenu
        ingredient = new JMenu("Ingredient");

        // Add the menu items to the Ingredient submenu
        addIngredient = new JMenuItem("Add Ingredient");
        removeIngredient = new JMenuItem("Remove Ingredient");

        // Add the menu items to the Ingredient submenu
        ingredient.add(addIngredient);
        ingredient.add(removeIngredient);

        // Add the menu items to the edit menu
        editMenu.add(recipe);
        editMenu.add(ingredient);

        // Add the edit menu to the menu bar
        add(editMenu);
    }

    // Expose the menu items
    public JMenuItem getAddIngredient() {
        return this.addIngredient;
    }

    public JMenuItem getAddRecipe() {
        return this.addRecipe;
    }

    public JMenuItem getRemoveRecipe() {
        return this.removeRecipe;
    }
}
