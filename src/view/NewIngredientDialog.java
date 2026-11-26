package view;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import model.Unit;

/**
 *
 * NewIngredientDialog.java
 *
 * Author: Ephraim Becker
 *
 * Creates a dialog for adding an ingredient
 */
public class NewIngredientDialog extends JDialog {

    private final JTextField ingredientTextField;
    private final JSpinner quantitySpinner;
    private final JComboBox<Unit> unitComboBox;
    private final JOptionPane optionPane;

    // private IngredientsModel ingredientsModel;
    public NewIngredientDialog(JFrame frame) {
        super(frame, "New Ingredient", true);

        ingredientTextField = new JTextField();
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 0.5, 100, 0.5));
        unitComboBox = new JComboBox<>(Unit.values());

        // Create an array of the text and components to be displayed.
        String msgNewIngredient = "Enter a new ingredient:";
        String msgQuantity = "Enter the quantity:";
        String unitMessage = "Choose a unit";
        Object[] array = {msgNewIngredient, ingredientTextField, msgQuantity, quantitySpinner, unitMessage, unitComboBox};

        optionPane = new JOptionPane(array);

        optionPane.addPropertyChangeListener(event -> {
            if (event.getSource() == optionPane
                    && JOptionPane.VALUE_PROPERTY.equals(event.getPropertyName())
                    && isVisible()) {

                setVisible(false);
                dispose();
            }
        });

        // Make this dialog display it.
        setContentPane(optionPane);

        pack();
        setLocationRelativeTo(frame);
    }

    public boolean showDialog() {
        optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);
        setVisible(true);

        return optionPane.getValue() != null
                && optionPane.getValue().equals(JOptionPane.OK_OPTION);
    }

    public void closeDialog() {
        setVisible(false);
        dispose();
    }

    public JTextField getIngredient() {
        return ingredientTextField;
    }

    public JSpinner getQuantity() {
        return quantitySpinner;
    }

    public JComboBox<Unit> getUnit() {
        return unitComboBox;
    }

    public JOptionPane getOptionPane() {
        return optionPane;
    }
}
