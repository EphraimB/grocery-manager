package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.IngredientsModel;
import tableModel.IngredientsTableModel;

public class IngredientsPanel extends JPanel {

    List<IngredientsModel> initData = new ArrayList<>();

    public IngredientsPanel(IngredientsTableModel recipeTableModel) {
        JTable recipeTable = new JTable(recipeTableModel);

        add(new JScrollPane(recipeTable));
    }
}
