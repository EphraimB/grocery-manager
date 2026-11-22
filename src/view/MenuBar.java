package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    JMenu fileMenu, editMenu, recipe, ingredient;
    JMenuItem saveMenuItem, closeMenuItem, addIngredient, removeIngredient, addRecipe, removeRecipe;

    public MenuBar() {
        // Build the file menu
        fileMenu = new JMenu("File");

        saveMenuItem = new JMenuItem("Save");
        closeMenuItem = new JMenuItem("Close");

        fileMenu.add(saveMenuItem);
        fileMenu.add(closeMenuItem);

        add(fileMenu);

        // Build the edit menu
        editMenu = new JMenu("Edit");

        // Build the Recipe submenu
        recipe = new JMenu("Recipe");

        addRecipe = new JMenuItem("Add Recipe");
        removeRecipe = new JMenuItem("Remove Recipe");

        recipe.add(addRecipe);
        recipe.add(removeRecipe);

        // Build the Ingredient submenu
        ingredient = new JMenu("Ingredient");

        addIngredient = new JMenuItem("Add Ingredient");
        removeIngredient = new JMenuItem("Remove Ingredient");

        ingredient.add(addIngredient);
        ingredient.add(removeIngredient);

        editMenu.add(recipe);
        editMenu.add(ingredient);

        add(editMenu);
    }

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
