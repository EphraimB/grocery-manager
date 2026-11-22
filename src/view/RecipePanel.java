package src.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import src.model.RecipeModel;
import src.tableModel.RecipeTableModel;

public class RecipePanel extends JPanel {

    List<RecipeModel> initData = new ArrayList<>();

    public RecipePanel(RecipeTableModel recipeTableModel) {
        JTable recipeTable = new JTable(recipeTableModel);

        add(new JScrollPane(recipeTable));
    }
}
