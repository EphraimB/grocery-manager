package src.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    JMenu fileMenu, editMenu;
    JMenuItem saveMenuItem, closeMenuItem, addItem, removeItem;

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

        addItem = new JMenuItem("Add Item");
        removeItem = new JMenuItem("Remove Item");

        editMenu.add(addItem);
        editMenu.add(removeItem);

        add(editMenu);
    }

    public JMenuItem getAddItem() {
        return this.addItem;
    }
}
