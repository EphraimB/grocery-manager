package view;

import javax.swing.JSplitPane;

import tableModel.IngredientsTableModel;

public class SplitPane extends JSplitPane {

    private IngredientsPanel ingredientsPanel;

    public SplitPane(IngredientsTableModel ingredientsTableModel) {
        super(JSplitPane.HORIZONTAL_SPLIT,
                null, new IngredientsPanel(ingredientsTableModel));
    }
}
