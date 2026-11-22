package view;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import listModel.RecipeListModel;
import model.RecipeModel;

public class RecipePanel extends JPanel {

    private final JList<RecipeModel> list;

    public RecipePanel(RecipeListModel model) {
        setLayout(new BorderLayout());

        list = new JList<>(model);

        add(new JScrollPane(list), BorderLayout.CENTER);
    }

    public JList<RecipeModel> getRecipeList() {
        return list;
    }
}
