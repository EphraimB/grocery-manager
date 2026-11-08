# Grocery Manager

## Description

The application will be a grocery management and weekly meal-planning dashboard. Users will be able to create an unlimited number of meals for each day of a recurring Sunday–Saturday week. Each day will contain meals, each meal will contain foods or recipes, and each food or recipe will contain its required groceries and ingredients. Grocery items and recipes can be reused across multiple meals without creating duplicate entries.

The dashboard will display the weekly meal plan in an organized format, with the calories, protein, and estimated cost of each grocery item. It will calculate nutritional and price totals for individual foods, meals, days, and the entire week.
The application will include a weekly budget feature that allows users to enter their available grocery allowance through a JTextField and assign prices to individual grocery items. It will calculate the projected grocery cost, compare it against the weekly allowance, and indicate whether the meal plan is affordable or whether meals or grocery quantities may need to be reduced.

The application will also track calories and protein from grocery items and calculate daily and weekly nutritional totals. Users will be able to compare these totals against their own nutritional goals to determine whether their planned meals meet their targets.
Finally, the application will generate a consolidated shopping list that combines repeated grocery items and calculates their total required quantities and estimated costs. Users will be able to export this list into an Excel spreadsheet with one click, making it convenient to use while shopping at the supermarket.

## Data Types

| Data Type | Purpose | Examples |
| --- | --- | --- |
| Double | Stores decimal values for nutritional information and quantities. | Protein, fractional grocery quantities |
| String | Stores names and text descriptions. | Grocery names, meal names, food/recipe names, categories |
| Integer | Stores whole-number values. | Calories, IDs, whole-number quantities |
| BigDecimal | Stores monetary values accurately. | Grocery prices, total costs, weekly grocery budget |
| DayOfWeek | Represents the days of the recurring weekly schedule. | Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday |
| Boolean | Stores true/false conditions. | Whether the weekly budget is met or nutritional goals are achieved |

## Phase 2: Planned Method Signatures

The following methods are planned for implementation in Phase 2. They will manage grocery items, recipes, weekly meal planning, budgeting, nutritional calculations, and shopping-list generation.

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

### 4. Budget and Nutritional Management

These methods will calculate grocery expenses and nutritional totals and compare them against user-defined goals.

```java
public void setWeeklyBudget(BigDecimal amount);
public BigDecimal calculateWeeklyCost();
public BigDecimal getRemainingBudget();
public void setNutritionGoals(int calories, BigDecimal protein);
public int calculateDailyCalories(DayOfWeek day);
public BigDecimal calculateDailyProtein(DayOfWeek day);
public boolean checkBudgetStatus();
public boolean checkNutritionGoals(DayOfWeek day);
```

### 5. Shopping List and Excel Export

These methods will generate a consolidated shopping list and export it to an Excel spreadsheet.

```java
public List<ShoppingListItem> generateShoppingList();
public void exportShoppingList(String filePath) throws IOException;
```

### 6. JTable Methods

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
