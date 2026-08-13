import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private String name;
    private String category;
    private String description;
    private List<String> ingredients;
    private String instructions;

    public Recipe(String name, String category, String description,
                  List<String> ingredients, String instructions) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return name;
    }
}