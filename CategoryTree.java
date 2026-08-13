import java.util.ArrayList;
import java.util.List;

//CategoryTree organizes recipes into categories using a Tree data structure.
public class CategoryTree {

    // A node represents one category in the tree
    private static class CategoryNode {

        // The name of the category
        String category;
        // A List of recipes belonging to category
        List<Recipe> recipes;
        // a List of child category nodes, stores any categories under this node
        List<CategoryNode> children;

        //New category node
        CategoryNode(String category) {
            this.category = category;
            this.recipes = new ArrayList<>();
            this.children = new ArrayList<>();
        }
    }

    // The top of our tree
    private CategoryNode root;
    //Constructor for CategoryTree, will contain all our recipe categories
    public CategoryTree() {
        root = new CategoryNode("Recipes");
    }

    // Add a category to the tree
    public void addCategory(String category) {

        if (findCategory(root, category) == null) {
            root.children.add(new CategoryNode(category));
        }
    }

    // Add a recipe to a category
    public void addRecipeToCategory(Recipe recipe) {

        CategoryNode categoryNode =
                findCategory(root, recipe.getCategory());

        if (categoryNode == null) {
            addCategory(recipe.getCategory());
            categoryNode = findCategory(root, recipe.getCategory());
        }

        categoryNode.recipes.add(recipe);
    }

    // Find a category in the tree
    private CategoryNode findCategory(
            CategoryNode node,
            String category) {

        if (node.category.equalsIgnoreCase(category)) {
            return node;
        }

        for (CategoryNode child : node.children) {

            CategoryNode result =
                    findCategory(child, category);

            if (result != null) {
                return result;
            }
        }

        return null;
    }

    // Get all recipes in a category
    public List<Recipe> getRecipesInCategory(String category) {

        CategoryNode categoryNode =
                findCategory(root, category);

        //return empty list if catgory doesnt exist
        if (categoryNode == null) {
            return new ArrayList<>();
        }

        //return all recipes stored in category
        return categoryNode.recipes;
    }

    // Get all category names
    public List<String> getCategories() {

        List<String> categories = new ArrayList<>();

        for (CategoryNode child : root.children) {
            categories.add(child.category);
        }

        return categories;
    }

    // Display the tree in the console
    public void printTree() {
        System.out.println("\nRecipe Category Tree:");
        printNode(root, 0);
    }

    private void printNode(
            CategoryNode node,
            int level) {

        System.out.println(
                "  ".repeat(level) + "- " + node.category
        );
        //print all recipes stored in category
        for (Recipe recipe : node.recipes) {

            System.out.println(
                    "  ".repeat(level + 1)
                            + "• "
                            + recipe.getName()
            );
        }

        //displays entire tree no matter what size
        for (CategoryNode child : node.children) {
            printNode(child, level + 1);
        }
    }
}