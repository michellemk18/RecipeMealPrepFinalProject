import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecipeManager {

    // List: stores all recipes
    private List<Recipe> recipes;

    // Hash Table: quickly finds a recipe by name
    private Map<String, Recipe> recipeTable;

    // Stores favorite recipes
    private Set<Recipe> favorites;

    public RecipeManager() {
        recipes = new ArrayList<>();
        recipeTable = new HashMap<>();
        favorites = new HashSet<>();
    }

    // Add a recipe
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        recipeTable.put(recipe.getName().toLowerCase(), recipe);
    }

    // Get all recipes
    public List<Recipe> getRecipes() {
        return recipes;
    }

    // Search for a recipe by name
    public Recipe findRecipe(String name) {
        if (name == null) {
            return null;
        }

        return recipeTable.get(name.toLowerCase());
    }

    // Search recipes by partial name
    public List<Recipe> searchRecipes(String searchText) {
        List<Recipe> results = new ArrayList<>();

        if (searchText == null) {
            return results;
        }

        String search = searchText.toLowerCase();

        for (Recipe recipe : recipes) {
            if (recipe.getName().toLowerCase().contains(search)) {
                results.add(recipe);
            }
        }

        return results;
    }

    // Get recipes by category
    public List<Recipe> getRecipesByCategory(String category) {
        List<Recipe> results = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if (recipe.getCategory().equalsIgnoreCase(category)) {
                results.add(recipe);
            }
        }

        return results;
    }

    // Add/remove favorite
    public void toggleFavorite(Recipe recipe) {
        if (favorites.contains(recipe)) {
            favorites.remove(recipe);
        } else {
            favorites.add(recipe);
        }
    }

    // Check if recipe is a favorite
    public boolean isFavorite(Recipe recipe) {
        return favorites.contains(recipe);
    }

    // Get all favorites
    public Set<Recipe> getFavorites() {
        return favorites;
    }

    public List<Recipe> sortRecipesAlphabetically() {

        List<Recipe> sortedRecipes =
                new ArrayList<>(recipes);

        // Bubble Sort
        for (int i = 0; i < sortedRecipes.size() - 1; i++) {

            for (int j = 0;
                 j < sortedRecipes.size() - 1 - i;
                 j++) {

                String name1 =
                        sortedRecipes.get(j).getName();

                String name2 =
                        sortedRecipes.get(j + 1).getName();

                if (name1.compareToIgnoreCase(name2) > 0) {

                    Recipe temp =
                            sortedRecipes.get(j);

                    sortedRecipes.set(
                            j,
                            sortedRecipes.get(j + 1)
                    );

                    sortedRecipes.set(
                            j + 1,
                            temp
                    );
                }
            }
        }

        return sortedRecipes;
    }
}