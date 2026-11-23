package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import model.Unit;
import tableModel.IngredientsTableModel;

public class IngredientsPanel extends JPanel {

    private CardLayout cardLayout;
    private JPanel cards;

    private JLabel placeholder;
    private JTable ingredientsTable;

    private static final String EMPTY = "empty";
    private static final String TABLE = "table";

    public IngredientsPanel(IngredientsTableModel recipeTableModel) {
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        ingredientsTable = new JTable(recipeTableModel);

        JComboBox<Unit> unitComboBox
                = new JComboBox<>(Unit.values());

        ingredientsTable.getColumnModel()
                .getColumn(3)
                .setCellEditor(new DefaultCellEditor(unitComboBox));

        placeholder = new JLabel("Select a recipe", SwingConstants.CENTER);

        cards.add(placeholder, EMPTY);
        cards.add(new JScrollPane(ingredientsTable), TABLE);

        add(cards, BorderLayout.CENTER);

        cardLayout.show(cards, EMPTY);
    }

    public void showPlaceholder() {
        // Show the empty card
        cardLayout.show(cards, EMPTY);
    }

    public void showTable() {
        // Show the table card
        cardLayout.show(cards, TABLE);
    }
}
