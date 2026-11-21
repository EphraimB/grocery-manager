package src.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import src.model.Recipe;

public class RecipeTableModel extends AbstractTableModel {

    private final String[] columnNames = {
        "id", "Ingredients", "Quantity", "Units"
    };
    private List<Recipe> data;

    /*= {
        {1, "Brown rice", 1, "cup"},
        {2, "Cucumber", .5, "piece"},
        {3, "Avocado", .5, "piece"},
        {4, "Salmon", 1 / 4, "pound"},
        {5, "Seaweed", 1, "piece"}
    };*/
    public RecipeTableModel(List<Recipe> data) {
        this.data = copyRecipes(data);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Recipe recipe = data.get(row);

        return switch (col) {
            case 0 ->
                recipe.getId();
            case 1 ->
                recipe.getIngredients();
            case 2 ->
                recipe.getQuantity();
            case 3 ->
                recipe.getUnits();
            default ->
                null;
        };
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
        return col == 0;
    }

    private static List<Recipe> copyRecipes(List<Recipe> recipes) {
        List<Recipe> copy = new ArrayList<>(recipes.size());

        for (Recipe recipe : recipes) {
            // copy.add(new Recipe(1, "Brown rice", "cup", 1));
            copy.add(new Recipe(recipe.getId(), recipe.getIngredients(), recipe.getUnits(), recipe.getQuantity()));
        }

        return copy;
    }
}
