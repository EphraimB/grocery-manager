package view;

import controller.IngredientController;
import controller.RecipeController;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import listModel.RecipeListModel;

public class Frame extends JFrame {

    public Frame() {
        // Calls the JFrame with the title
        super("Grocery manager");

        // Instantiates the components
        MenuBar menuBar = new MenuBar();
        RecipeController recipeController = new RecipeController(menuBar, new RecipeListModel(new ArrayList<>()));
        IngredientController ingredientController = new IngredientController(menuBar);
        Header header = new Header();
        Stepper stepper = new Stepper(recipeController.getRecipeListModel(), ingredientController.getIngredientsTableModel());

        // Add the menu bar to the top
        add(menuBar, BorderLayout.NORTH);

        // Content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(header, BorderLayout.NORTH);
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
