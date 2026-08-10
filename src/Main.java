import javax.swing.SwingUtilities;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        RecipeManager manager = new RecipeManager();

        // Recipe 1: chicken alfredo pasta
        Recipe chickenAlfredo = new Recipe(
                "Chicken Alfredo",
                "Dinner",
                "Creamy Alfredo pasta with grilled chicken.",
                Arrays.asList(
                        "Chicken breast",
                        "Fettuccine pasta",
                        "Heavy cream",
                        "Parmesan cheese",
                        "Garlic"
                ),
                "Cook pasta. Grill chicken. Prepare Alfredo sauce. "
                        + "Combine everything and serve."
        );

        // Recipe 2: spaghetti and meatballs
        Recipe spaghetti = new Recipe(
                "Spaghetti and Meatballs",
                "Dinner",
                "Classic spaghetti with a rich tomato sauce and meatballs.",
                Arrays.asList(
                        "Spaghetti",
                        "Ground beef",
                        "Tomato sauce",
                        "Onion",
                        "Garlic"
                ),
                "Cook spaghetti. Prepare meat sauce. "
                        + "Combine sauce with pasta and serve."
        );

        // Recipe 3: choco chip pancakes
        Recipe pancakes = new Recipe(
                "Chocolate Chip Pancakes",
                "Breakfast",
                "Fluffy pancakes with chocolate chips incorporated in the batter.",
                Arrays.asList(
                        "Flour",
                        "Milk",
                        "Eggs",
                        "Chocolate Chips",
                        "Maple syrup"
                ),
                "Mix ingredients. Cook pancakes on a skillet. "
                        + "Add chocolate chips and maple syrup."
        );

        // Recipe 4: Caesar salad
        Recipe caesarSalad = new Recipe(
                "Chicken Caesar Salad",
                "Lunch",
                "Crunchy salad with grilled chicken and Caesar dressing.",
                Arrays.asList(
                        "Romaine lettuce",
                        "Chicken breast",
                        "Parmesan cheese",
                        "Croutons",
                        "Caesar dressing"
                ),
                "Grill chicken. Chop lettuce. "
                        + "Combine ingredients and add dressing."
        );

        // Add recipes to our manager
        manager.addRecipe(chickenAlfredo);
        manager.addRecipe(spaghetti);
        manager.addRecipe(pancakes);
        manager.addRecipe(caesarSalad);

        // Test that the recipes were added
        System.out.println("RecipeHub started!");
        System.out.println("Number of recipes: " + manager.getRecipes().size());

        System.out.println("\nRecipes:");

        for (Recipe recipe : manager.getRecipes()) {
            System.out.println("- " + recipe.getName());
        }

        // TEST WEEKLY MEAL PLAN
        MealPlan mealPlan = new MealPlan();

        mealPlan.addMeal("Monday", chickenAlfredo);
        mealPlan.addMeal("Tuesday", spaghetti);
        mealPlan.addMeal("Wednesday", pancakes);

        System.out.println("\nWeekly Meal Plan:");

        for (String day : mealPlan.getWeeklyPlan().keySet()) {
            System.out.println(
                    day + ": " + mealPlan.getMeal(day).getName()
            );
        }

        // Test undo
        mealPlan.undoLastMeal();

        System.out.println("\nAfter Undo:");

        for (String day : mealPlan.getWeeklyPlan().keySet()) {
            System.out.println(
                    day + ": " + mealPlan.getMeal(day).getName()
            );
        }

        // TEST RECIPE GRAPH
        RecipeGraph recipeGraph = new RecipeGraph();

        // Add recipes to the graph
        recipeGraph.addRecipe(chickenAlfredo);
        recipeGraph.addRecipe(spaghetti);
        recipeGraph.addRecipe(pancakes);
        recipeGraph.addRecipe(caesarSalad);

        // Create recipe connections
        recipeGraph.addConnection(chickenAlfredo, spaghetti);
        recipeGraph.addConnection(chickenAlfredo, caesarSalad);
        recipeGraph.addConnection(spaghetti, caesarSalad);
        recipeGraph.addConnection(pancakes, chickenAlfredo);

        // Display related recipes
        System.out.println("\nRelated to Chicken Alfredo:");

        for (Recipe recipe :
                recipeGraph.getRelatedRecipes(chickenAlfredo)) {

            System.out.println("- " + recipe.getName());
        }

        // TEST CATEGORY TREE
        CategoryTree categoryTree = new CategoryTree();

        // Add recipes to the category tree
        categoryTree.addRecipeToCategory(chickenAlfredo);
        categoryTree.addRecipeToCategory(spaghetti);
        categoryTree.addRecipeToCategory(pancakes);
        categoryTree.addRecipeToCategory(caesarSalad);

        // Display the category tree
        categoryTree.printTree();

        // Display recipes in the Dinner category
        System.out.println("\nDinner Recipes:");

        for (Recipe recipe :
                categoryTree.getRecipesInCategory("Dinner")) {

            System.out.println("- " + recipe.getName());
        }

        //start recipehub gui
        SwingUtilities.invokeLater(() -> {

            RecipeHubGUI gui = new RecipeHubGUI(
                    manager,
                    mealPlan,
                    recipeGraph,
                    categoryTree
            );

            gui.setVisible(true);
        });
    }
}