package src.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import src.model.RecipeModel;

public class RecipeTableModel extends AbstractTableModel {

    private final String[] columnNames = {
        "id", "Ingredients", "Quantity", "Units"
    };
    private List<RecipeModel> recipes = new ArrayList<>();
    private int id = 1;

    /*= {
        {1, "Brown rice", 1, "cup"},
        {2, "Cucumber", .5, "piece"},
        {3, "Avocado", .5, "piece"},
        {4, "Salmon", 1 / 4, "pound"},
        {5, "Seaweed", 1, "piece"}
    };*/
    public RecipeTableModel(List<RecipeModel> recipes) {
        this.recipes = copyRecipes(recipes);
    }

    @Override
    public int getRowCount() {
        return recipes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        RecipeModel recipeModel = recipes.get(row);

        return switch (col) {
            case 0 ->
                recipeModel.getId();
            case 1 ->
                recipeModel.getIngredients();
            case 2 ->
                recipeModel.getQuantity();
            case 3 ->
                recipeModel.getUnits();
            default ->
                null;
        };
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        RecipeModel recipeModel = recipes.get(row);

        switch (col) {
            case 1:
                recipeModel.setIngredients(value.toString());
                break;
            case 2:
                recipeModel.setQuantity(Double.parseDouble(value.toString()));
                break;
            case 3:
                recipeModel.setUnits(value.toString());
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

    private static List<RecipeModel> copyRecipes(List<RecipeModel> recipes) {
        List<RecipeModel> copy = new ArrayList<>(recipes.size());

        for (RecipeModel recipe : recipes) {
            copy.add(new RecipeModel(recipe.getId(), recipe.getIngredients(), recipe.getQuantity(), recipe.getUnits()
            ));
        }

        return copy;
    }

    public void addRecipe(RecipeModel recipe) {
        recipe.setId(id++);
        recipes.add(recipe);

        int row = recipes.size() - 1;

        fireTableRowsInserted(row, row);
    }
}
