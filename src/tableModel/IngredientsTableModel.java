package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.IngredientsModel;
import model.Unit;

public class IngredientsTableModel extends AbstractTableModel {

    private final String[] columnNames = {
        "id", "Ingredients", "Quantity", "Units"
    };
    private List<IngredientsModel> ingredients = new ArrayList<>();
    private int id = 1;

    public IngredientsTableModel(List<IngredientsModel> ingredients) {
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

        return switch (col) {
            case 0 ->
                ingredientsModel.getId();
            case 1 ->
                ingredientsModel.getIngredients();
            case 2 ->
                ingredientsModel.getQuantity();
            case 3 ->
                ingredientsModel.getUnits();
            default ->
                null;
        };
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        IngredientsModel ingredientsModel = ingredients.get(row);
        switch (col) {
            case 1:
                ingredientsModel.setIngredients(value.toString());
                break;
            case 2:
                ingredientsModel.setQuantity(Double.parseDouble(value.toString()));
                break;
            case 3:
                ingredientsModel.setUnits((Unit) value);
                break;
        }

        fireTableCellUpdated(row, col);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col != 0;
    }

    private static List<IngredientsModel> copyIngredients(List<IngredientsModel> ingredients) {
        List<IngredientsModel> copy = new ArrayList<>(ingredients.size());

        for (IngredientsModel ingredient : ingredients) {
            copy.add(new IngredientsModel(ingredient.getId(), ingredient.getIngredients(), ingredient.getQuantity(), ingredient.getUnits()
            ));
        }

        return copy;
    }

    public void addIngredient(IngredientsModel ingredient) {
        ingredient.setId(id++);
        ingredients.add(ingredient);

        int row = ingredients.size() - 1;

        fireTableRowsInserted(row, row);
    }
}
