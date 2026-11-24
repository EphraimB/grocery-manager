# Grocery Manager

## Description

The application will be a grocery management and weekly meal-planning dashboard. Users will be able to create an unlimited number of meals for each day of a recurring Sunday–Saturday week. Each day will contain meals, each meal will contain foods or recipes, and each food or recipe will contain its required groceries and ingredients. Grocery items and recipes can be reused across multiple meals without creating duplicate entries.

Finally, the application will generate a consolidated shopping list that combines repeated grocery items and calculates their total required quantities and estimated costs. Users will be able to export this list into a text file with one click, making it convenient to use while shopping at the supermarket.

## Data Types

| Data Type | Purpose                                               | Examples                                                       |
| --------- | ----------------------------------------------------- | -------------------------------------------------------------- |
| Double    | Stores decimal values for quantities.                 | fractional grocery quantities                                  |
| String    | Stores names and text descriptions.                   | Grocery names, meal names, food/recipe names, categories       |
| Integer   | Stores whole-number values.                           | Calories, IDs, whole-number quantities                         |
| DayOfWeek | Represents the days of the recurring weekly schedule. | Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday |

## Phase 2: Planned Method Signatures

The following methods are planned for implementation in Phase 2. They will manage grocery items, recipes, weekly meal planning, and shopping-list generation.

### 1. Grocery Management

These methods will allow users to create, remove, update, and retrieve grocery items.

```java
public void addGrocery(GroceryItem item);
public void removeGrocery(int groceryID);
public void updateGrocery(GroceryItem item);
public GroceryItem getGrocery(int groceryID);
public List<GroceryItem> getAllGroceries();
```

### 2. Recipe and Ingredient Management

These methods will allow users to create reusable recipes and associate grocery ingredients with them.

```java
public void addRecipe(Recipe recipe);
public void removeRecipe(int recipeID);
public void updateRecipe(Recipe recipe);
public void addIngredient(int recipeID, int groceryID, BigDecimal quantity);
public void removeIngredient(int recipeID, int groceryID);
public void updateIngredientQuantity(int recipeID, int groceryID, BigDecimal quantity);
public List<RecipeIngredient> getRecipeIngredients(int recipeID);
```

### 3. Weekly Meal Planning

These methods will allow users to organize meals by day and reuse recipes throughout the week.

```java
public void addMeal(DayOfWeek day, String mealName);
public void removeMeal(int mealID);
public void updateMeal(int mealID, String mealName);
public void addRecipeToMeal(int mealID, int recipeID);
public void removeRecipeFromMeal(int mealID, int recipeID);
public List<Meal> getMealsForDay(DayOfWeek day);
```

### 4. Shopping List and Excel Export

These methods will generate a consolidated shopping list and export it to an Excel spreadsheet.

```java
public List<ShoppingListItem> generateShoppingList();
public void exportShoppingList(String filePath) throws IOException;
```

### 5. JTable Methods

The custom `GroceryTableModel` class will extend Java's `AbstractTableModel` and provide the data displayed in the grocery JTable.

```java
public int getRowCount();
public int getColumnCount();
public String getColumnName(int column);
public Object getValueAt(int row, int column);
public void setValueAt(Object value, int row, int column);
public boolean isCellEditable(int row, int column);
```

These methods will control how grocery information appears in the JTable, including retrieving, displaying, and editing individual cell values.

### Look and Feel (View)

The application will use a simple, modern, one-page dashboard with a card-based layout. Each day of the recurring Sunday–Saturday week will be displayed as an individual card. Within each day card, users can add an unlimited number of food or meal cards.

Each food card will display its recipe ingredients as removable chips. Each chip will consist of a styled `JLabel` displaying the ingredient name and a small `JButton` displaying an X, visually integrated into the same chip. Clicking the X will remove the ingredient from that recipe.

An **Add Ingredient** button will open a small `JDialog` popup containing a `JTextField` for searching the grocery database and a `JList` displaying matching grocery items. Users can select an existing grocery, specify its quantity, and add it to the recipe. If an ingredient does not already exist, users will be able to create a new grocery item and save it to the reusable grocery database.

Each food card will display its grocery quantities, calories, protein, and prices, along with combined nutritional and cost totals. Daily and weekly summaries will calculate overall calories, protein, and projected grocery expenses.

The interface will use a clean, minimal design with light backgrounds, subtle colors, and clearly labeled controls for adding, editing, and removing foods and groceries. A `JTable` will be used where appropriate for managing structured grocery information. A clearly visible Excel export button will generate a consolidated shopping list.

## Usage

In order to start the Shopping List GUI program, you need to compile it and then run it with the following commands:

1. `find src -name "*.java" -print0 | xargs -0 javac -d out`
2. `java -cp "out" Main`
