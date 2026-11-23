package view;

import java.awt.BorderLayout;
import java.util.function.Consumer;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.RecipeListModel;
import model.RecipeModel;

public class RecipePanel extends JPanel {

    private final JList<RecipeModel> list;

    public RecipePanel(RecipeListModel model, Consumer<RecipeModel> onRecipeSelected) {
        setLayout(new BorderLayout());

        list = new JList<>(model);

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                onRecipeSelected.accept(list.getSelectedValue());
            }
        });

        onRecipeSelected.accept(list.getSelectedValue());

        add(new JScrollPane(list), BorderLayout.CENTER);
    }

    public JList<RecipeModel> getRecipeList() {
        return list;
    }
}
