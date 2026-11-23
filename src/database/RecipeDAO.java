package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.RecipeModel;

public class RecipeDAO {

    private DatabaseManager databaseManager;

    public RecipeDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public List<RecipeModel> getAll() throws SQLException {
        String query = "SELECT * FROM recipes";

        try (
                Connection conn = databaseManager.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
            List<RecipeModel> recipes = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + ", " + name);

                recipes.add(new RecipeModel(id, name));
            }

            return recipes;
        }
    }
}
