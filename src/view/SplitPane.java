package view;

import controller.RecipeController;
import javax.swing.JSplitPane;
import listModel.RecipeListModel;
import tableModel.IngredientsTableModel;

public class SplitPane extends JSplitPane {

    public SplitPane(
            RecipeListModel recipeListModel,
            IngredientsTableModel ingredientsTableModel,
            RecipeController recipeController) {

        super(JSplitPane.HORIZONTAL_SPLIT,
                new RecipePanel(recipeListModel, recipeController::setSelectedRecipe),
                new IngredientsPanel(ingredientsTableModel)
        );
    }
}
