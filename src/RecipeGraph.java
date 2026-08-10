import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecipeGraph {

    // Each recipe is connected to a list of related recipes
    private Map<Recipe, List<Recipe>> graph;

    public RecipeGraph() {
        graph = new HashMap<>();
    }

    // Add a recipe to the graph
    public void addRecipe(Recipe recipe) {
        graph.putIfAbsent(recipe, new ArrayList<>());
    }

    // Connect two recipes together
    public void addConnection(Recipe recipe1, Recipe recipe2) {

        addRecipe(recipe1);
        addRecipe(recipe2);

        graph.get(recipe1).add(recipe2);
        graph.get(recipe2).add(recipe1);
    }

    // Get recipes related to a specific recipe
    public List<Recipe> getRelatedRecipes(Recipe recipe) {

        if (!graph.containsKey(recipe)) {
            return new ArrayList<>();
        }

        return graph.get(recipe);
    }

    // Get all recipes in the graph
    public Map<Recipe, List<Recipe>> getGraph() {
        return graph;
    }
}