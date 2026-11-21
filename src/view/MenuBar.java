package src.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    JMenuBar menuBar;
    JMenu fileMenu, editMenu;
    JMenuItem saveMenuItem, closeMenuItem;

    public MenuBar() {
        // Build the file menu
        fileMenu = new JMenu("File");

        saveMenuItem = new JMenuItem("Save");
        closeMenuItem = new JMenuItem("Close");

        fileMenu.add(saveMenuItem);
        fileMenu.add(closeMenuItem);

        add(fileMenu);
    }
}
