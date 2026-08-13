import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MealPlan {

    // Stores the meal assigned to each day
    private Map<String, Recipe> weeklyPlan;

    // Stack stores meal additions so we can undo the last one
    private Stack<MealAction> actionHistory;

    public MealPlan() {
        weeklyPlan = new HashMap<>();
        actionHistory = new Stack<>();
    }

    // Add a recipe to a specific day
    public void addMeal(String day, Recipe recipe) {

        // Remember what was there before
        Recipe previousRecipe = weeklyPlan.get(day);

        // Add the new meal
        weeklyPlan.put(day, recipe);

        // Save this action for undo
        actionHistory.push(
                new MealAction(day, previousRecipe)
        );
    }

    // Undo the most recent meal addition
    public void undoLastMeal() {

        if (actionHistory.isEmpty()) {
            return;
        }

        MealAction lastAction = actionHistory.pop();

        if (lastAction.previousRecipe == null) {
            weeklyPlan.remove(lastAction.day);
        } else {
            weeklyPlan.put(
                    lastAction.day,
                    lastAction.previousRecipe
            );
        }
    }

    // Get the recipe assigned to a day
    public Recipe getMeal(String day) {
        return weeklyPlan.get(day);
    }

    // Get the entire weekly plan
    public Map<String, Recipe> getWeeklyPlan() {
        return weeklyPlan;
    }

    // Check if there is something to undo
    public boolean canUndo() {
        return !actionHistory.isEmpty();
    }

    // Stores information about a meal change
    private static class MealAction {

        private String day;
        private Recipe previousRecipe;

        public MealAction(String day, Recipe previousRecipe) {
            this.day = day;
            this.previousRecipe = previousRecipe;
        }
    }
}