package view;

import controller.IngredientController;
import controller.RecipeController;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.RecipeListModel;

/**
 *
 * Frame.java
 *
 * Author: Ephraim Becker
 *
 * The JFrame component
 */
public class Frame extends JFrame {

    // Constructor
    public Frame() {
        // Calls the JFrame with the title
        super("Grocery manager");

        // Instantiates the MenuBar
        MenuBar menuBar = new MenuBar();
        RecipeListModel recipeListModel = new RecipeListModel(new ArrayList<>());

        // Initialize the controllers
        RecipeController recipeController = new RecipeController(menuBar, recipeListModel);
        IngredientController ingredientController = new IngredientController(menuBar, this);

        // Initialize the header
        Header header = new Header();

        // Initialize the stepper
        Stepper stepper = new Stepper(
                recipeController.getRecipeListModel(),
                ingredientController.getIngredientsTableModel(),
                recipeController,
                ingredientController
        );

        // Add the menu bar to the top
        add(menuBar, BorderLayout.NORTH);

        // Content panel - A JPanel with a Border Layout
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Puts the header at the top of the content panel
        contentPanel.add(header, BorderLayout.NORTH);

        // Puts the stepper at the remaining space of the content panel
        contentPanel.add(stepper, BorderLayout.CENTER);

        // Add the content panel to the center
        add(contentPanel, BorderLayout.CENTER);

        // Program exits on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets the dimension for the frame
        pack();

        // Puts window in the center of the screen
        setLocationRelativeTo(null);
    }
}
