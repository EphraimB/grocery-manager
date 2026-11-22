package view;

import javax.swing.JSplitPane;
import model.RecipeListModel;
import tableModel.IngredientsTableModel;

public class SplitPane extends JSplitPane {

    public SplitPane(RecipeListModel recipeListModel, IngredientsTableModel ingredientsTableModel) {
        super(JSplitPane.HORIZONTAL_SPLIT,
                new RecipePanel(recipeListModel), new IngredientsPanel(ingredientsTableModel));
    }
}
