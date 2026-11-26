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

    // Class fields
    private final JTextField ingredientTextField;
    private final JSpinner quantitySpinner;
    private final JComboBox<Unit> unitComboBox;
    private final JOptionPane optionPane;

    /**
     * Constructor
     *
     * @param frame The JFrame
     */
    public NewIngredientDialog(JFrame frame) {
        // Calls the JDialog with the title
        super(frame, "New Ingredient", true);

        // Initializes a new text field
        ingredientTextField = new JTextField();

        // Initializes a new spinner with numbers going from .5 to 100 in .5 increments initialized to 1
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 0.5, 100, 0.5));

        // Initializes a new combo box with the unit values
        unitComboBox = new JComboBox<>(Unit.values());

        // Create an array of the text and components to be displayed.
        String msgNewIngredient = "Enter a new ingredient:";
        String msgQuantity = "Enter the quantity:";
        String unitMessage = "Choose a unit";
        Object[] array = {msgNewIngredient, ingredientTextField, msgQuantity, quantitySpinner, unitMessage, unitComboBox};

        // Initializes an option pane for the dialog with the array
        optionPane = new JOptionPane(array);

        // Listens for change in the inputs in the dialog
        optionPane.addPropertyChangeListener(event -> {
            // Checks if the event that occurred is equaled to the option pane, 
            // the value property of the option pane is equaled to the event property name, and is visible
            if (event.getSource() == optionPane
                    && JOptionPane.VALUE_PROPERTY.equals(event.getPropertyName())
                    && isVisible()) {

                // Hide the dialog
                setVisible(false);

                // Releases resources for this dialog
                dispose();
            }
        });

        // Make this dialog display it.
        setContentPane(optionPane);

        // Fits the window size to the content
        pack();

        // Centers the dialog to the JFrame
        setLocationRelativeTo(frame);
    }

    /**
     * Shows the dialog
     *
     * @return
     */
    public boolean showDialog() {
        // Sets the option pane value to a value not initialized
        optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

        // Shows the dialog
        setVisible(true);

        // Returns true or false depending if the value isn't null and ok is clicked
        return optionPane.getValue() != null
                && optionPane.getValue().equals(JOptionPane.OK_OPTION);
    }

    /**
     * Closes the dialog
     */
    public void closeDialog() {
        // Hides the dialog
        setVisible(false);

        // Clears resources for this dialog
        dispose();
    }

    // Exposes the dialog inputs
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
