package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * IngredientsTableModel.java
 *
 * Author: Ephraim Becker
 *
 * The table model for the ingredients table
 */
public class IngredientsTableModel extends AbstractTableModel {

    // Class fields
    private final String[] columnNames = {
        "id", "Recipe id", "Ingredients", "Quantity", "Units"
    };
    private List<IngredientsModel> ingredients = new ArrayList<>();
    private int id = 1;

    /**
     * Constructor
     *
     * @param ingredients A list of ingredients
     */
    public IngredientsTableModel(List<IngredientsModel> ingredients) {
        // Sets the ingredients to a copy of the ingredients
        this.ingredients = copyIngredients(ingredients);
    }

    @Override
    public int getRowCount() {
        return ingredients.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        IngredientsModel ingredientsModel = ingredients.get(row);

        // Returns the correct column accordingly
        return switch (col) {
            case 0 ->
                ingredientsModel.getId();
            case 1 ->
                ingredientsModel.getRecipeId();
            case 2 ->
                ingredientsModel.getIngredients();
            case 3 ->
                ingredientsModel.getQuantity();
            case 4 ->
                ingredientsModel.getUnits();
            default ->
                null;
        };
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        IngredientsModel ingredientsModel = ingredients.get(row);

        // Sets the values of the columns accordingly to the column value
        switch (col) {
            case 1 ->
                ingredientsModel.setRecipeId((int) value);
            case 2 ->
                ingredientsModel.setIngredients(value.toString());
            case 3 ->
                ingredientsModel.setQuantity(Double.parseDouble(value.toString()));
            case 4 ->
                ingredientsModel.setUnits((Unit) value);
        }

        // Updates the table cells
        fireTableCellUpdated(row, col);
    }

    @Override
    public String getColumnName(int column) {
        // Returns the column names
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return switch (column) {
            case 0 ->
                Integer.class;
            case 1 ->
                Integer.class;
            case 2 ->
                String.class;
            case 3 ->
                Double.class;
            case 4 ->
                Unit.class;
            default ->
                Object.class;
        };
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        // Makes every column except the first one editable
        return col > 1;
    }

    /**
     * Copies the ingredients
     *
     * @param ingredients A list of ingredients
     *
     * @return A list of ingredients
     */
    private static List<IngredientsModel> copyIngredients(List<IngredientsModel> ingredients) {
        // Initializes an ArrayList with a size of the capacity of the ingredients
        List<IngredientsModel> copy = new ArrayList<>(ingredients.size());

        // Loops through the ingredients
        for (IngredientsModel ingredient : ingredients) {
            // Adds the initialized ingredients model to the list of ingredients
            copy.add(new IngredientsModel(ingredient.getId(), ingredient.getRecipeId(), ingredient.getIngredients(), ingredient.getQuantity(), ingredient.getUnits()
            ));
        }

        // Returns the copied list of ingredients
        return copy;
    }

    /**
     * Adds an ingredient to the model
     *
     * @param ingredient The ingredient model
     */
    public void addIngredient(IngredientsModel ingredient) {
        // Sets the id on the ingredients model with it incremented
        ingredient.setId(id++);

        // Adds the ingredient to the ingredients
        ingredients.add(ingredient);

        // Sets the row to the ingredients size
        int row = ingredients.size() - 1;

        // Updates the inserted row cell
        fireTableRowsInserted(row, row);
    }
}
