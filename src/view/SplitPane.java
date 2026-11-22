package view;

import javax.swing.JSplitPane;
import tableModel.IngredientsTableModel;

public class SplitPane extends JSplitPane {

    public SplitPane(IngredientsTableModel ingredientsTableModel) {
        super(JSplitPane.HORIZONTAL_SPLIT,
                new RecipePanel(), new IngredientsPanel(ingredientsTableModel));
    }
}
