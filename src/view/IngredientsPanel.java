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
import model.IngredientsTableModel;
import model.Unit;

/**
 *
 * IngredientsPanel.java
 *
 * Author: Ephraim Becker
 *
 * The IngredientsPanel component that shows either a JTable or a placeholder
 */
public class IngredientsPanel extends JPanel {

    // Class fields
    private final CardLayout cardLayout;
    private final JPanel cards;

    private final JLabel placeholder;
    private final JTable ingredientsTable;

    private static final String EMPTY = "empty";
    private static final String TABLE = "table";

    /**
     * Constructor
     *
     * @param ingredientsTableModel The ingredients table model
     */
    public IngredientsPanel(IngredientsTableModel ingredientsTableModel) {
        // Initializes a new Card Layout
        cardLayout = new CardLayout();

        // Adds the Card Layout to the JPanel
        cards = new JPanel(cardLayout);

        // Adds a new JTable
        ingredientsTable = new JTable(ingredientsTableModel);

        // Adds a new unit combo box
        JComboBox<Unit> unitComboBox
                = new JComboBox<>(Unit.values());

        // Gets the unit column
        ingredientsTable.getColumnModel()
                .getColumn(3)
                .setCellEditor(new DefaultCellEditor(unitComboBox));

        // Adds the placeholder
        placeholder = new JLabel("Select a recipe", SwingConstants.CENTER);

        // Adds the placeholder to the cards
        cards.add(placeholder, EMPTY);

        // Adds the ingredients table to the scroll pane which adds it to the cards
        cards.add(new JScrollPane(ingredientsTable), TABLE);

        // Adds the cards to this component
        add(cards, BorderLayout.CENTER);

        // Initially shows the placeholder
        cardLayout.show(cards, EMPTY);
    }

    /**
     * Shows the placeholder
     */
    public void showPlaceholder() {
        cardLayout.show(cards, EMPTY);
    }

    /**
     * Shows the ingredients table
     */
    public void showTable() {
        cardLayout.show(cards, TABLE);
    }
}
