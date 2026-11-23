package view;

import controller.RecipeController;
import javax.swing.JSplitPane;
import model.IngredientsTableModel;
import model.RecipeListModel;

public class SplitPane extends JSplitPane {

    private IngredientsPanel ingredientsPanel;

    public SplitPane(
            RecipeListModel recipeListModel,
            IngredientsTableModel ingredientsTableModel,
            RecipeController recipeController) {

        super(JSplitPane.HORIZONTAL_SPLIT);

        ingredientsPanel = new IngredientsPanel(ingredientsTableModel);

        RecipePanel recipePanel = new RecipePanel(
                recipeListModel,
                selectedRecipe -> {
                    recipeController.setSelectedRecipe(selectedRecipe);

                    if (selectedRecipe == null) {
                        ingredientsPanel.showPlaceholder();
                    } else {
                        ingredientsPanel.showTable();
                    }
                }
        );

        setLeftComponent(recipePanel);
        setRightComponent(ingredientsPanel);
    }
}
