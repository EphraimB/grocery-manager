package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    JMenu fileMenu, editMenu;
    JMenuItem saveMenuItem, closeMenuItem, addIngredient, removeIngredient;

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

        addIngredient = new JMenuItem("Add Ingredient");
        removeIngredient = new JMenuItem("Remove Ingredient");

        editMenu.add(addIngredient);
        editMenu.add(removeIngredient);

        add(editMenu);
    }

    public JMenuItem getAddIngredient() {
        return this.addIngredient;
    }
}
