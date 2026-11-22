package view;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Unit;
import tableModel.IngredientsTableModel;

public class IngredientsPanel extends JPanel {

    public IngredientsPanel(IngredientsTableModel recipeTableModel) {
        JTable ingredientsTable = new JTable(recipeTableModel);

        JComboBox<Unit> unitComboBox
                = new JComboBox<>(Unit.values());

        ingredientsTable.getColumnModel()
                .getColumn(3)
                .setCellEditor(new DefaultCellEditor(unitComboBox));

        add(new JScrollPane(ingredientsTable));
    }
}
