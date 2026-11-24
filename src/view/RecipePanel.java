package view;

import java.awt.BorderLayout;
import java.util.function.Consumer;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.RecipeListModel;
import model.RecipeModel;

/**
 *
 * RecipePanel.java
 *
 * Author: Ephraim Becker
 *
 * The recipe panel that shows a JList of recipes
 */
public class RecipePanel extends JPanel {

    // JList class field
    private final JList<RecipeModel> list;

    /**
     * Constructor
     *
     * @param model The recipe list model
     * @param onRecipeSelected
     */
    public RecipePanel(RecipeListModel model, Consumer<RecipeModel> onRecipeSelected) {
        // Sets the layout to a Border Layout
        setLayout(new BorderLayout());

        // Adds a new JList
        list = new JList<>(model);

        // Adds a listener for the JList
        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                onRecipeSelected.accept(list.getSelectedValue());
            }
        });

        onRecipeSelected.accept(list.getSelectedValue());

        // Adds the recipe list to the scroll pane which adds it to the panel
        add(new JScrollPane(list), BorderLayout.CENTER);
    }

    /**
     * Exposes the recipe list
     *
     * @return The recipe list
     */
    public JList<RecipeModel> getRecipeList() {
        return list;
    }
}
