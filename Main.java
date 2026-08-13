import javax.swing.SwingUtilities;
import java.util.Arrays;

/*
 * RecipeHub Main Class
 *
 * This class:
 * 1. Creates recipes.
 * 2. Adds recipes to the RecipeManager.
 * 3. Creates the Recipe Graph.
 * 4. Creates the Category Tree.
 * 5. Starts the RecipeHub GUI.
 */

public class Main {
    public static void main(String[] args) {
        //recipe manager
        RecipeManager manager = new RecipeManager();

        //BREAKFAST OPTIONS:
        //Chocolate Chip Pancakes
        Recipe pancakes = new Recipe(
                "Chocolate Chip Pancakes",
                "Breakfast",
                "Fluffy pancakes with chocolate chips and maple syrup.",
                Arrays.asList(
                        "Flour",
                        "Milk",
                        "Eggs",
                        "Chocolate chips",
                        "Maple syrup"
                ),
                "Mix ingredients. Cook pancakes on a skillet. "
                        + "Add chocolate chips and serve with maple syrup."
        );


        //French Toast
        Recipe frenchToast = new Recipe(
                "French Toast",
                "Breakfast",
                "Golden French toast topped with maple syrup.",
                Arrays.asList(
                        "Bread",
                        "Eggs",
                        "Milk",
                        "Cinnamon",
                        "Maple syrup"
                ),
                "Whisk eggs, milk, and cinnamon. Dip bread into mixture. "
                        + "Cook on a skillet until golden brown."
        );


        //Breakfast Burrito
        Recipe breakfastBurrito = new Recipe(
                "Breakfast Burrito",
                "Breakfast",
                "A hearty breakfast burrito filled with eggs, cheese, and potatoes.",
                Arrays.asList(
                        "Flour tortilla",
                        "Eggs",
                        "Cheddar cheese",
                        "Potatoes",
                        "Salsa"
                ),
                "Cook potatoes and scrambled eggs. Add ingredients to tortilla. "
                        + "Roll into a burrito and serve with salsa."
        );


        //Scrambled Eggs on Toast
        Recipe scrambledEggs = new Recipe(
                "Scrambled Eggs on Toast",
                "Breakfast",
                "Simple scrambled eggs served with crispy toast.",
                Arrays.asList(
                        "Eggs",
                        "Bread",
                        "Butter",
                        "Salt",
                        "Pepper"
                ),
                "Whisk eggs with salt and pepper. Cook in butter until scrambled. "
                        + "Toast bread and serve together."
        );


        //Waffles
        Recipe waffles = new Recipe(
                "Waffles",
                "Breakfast",
                "Crispy waffles topped with maple syrup.",
                Arrays.asList(
                        "Flour",
                        "Milk",
                        "Eggs",
                        "Maple syrup"
                ),
                "Prepare waffle batter by mixing flour, milk, and eggs. "
                        + "Cook in a waffle iron and serve with syrup."
        );


        //Avocado Toast
        Recipe avocadoToast = new Recipe(
                "Avocado Toast",
                "Breakfast",
                "Creamy avocado spread over toasted bread.",
                Arrays.asList(
                        "Bread",
                        "Avocado",
                        "Lemon juice",
                        "Salt",
                        "Pepper"
                ),
                "Toast the bread. Mash avocado with lemon juice, salt, and pepper. "
                        + "Spread avocado over toast."
        );


        //Breakfast Quesadilla
        Recipe breakfastQuesadilla = new Recipe(
                "Breakfast Quesadilla",
                "Breakfast",
                "Crispy tortilla filled with eggs and melted cheese.",
                Arrays.asList(
                        "Flour tortilla",
                        "Eggs",
                        "Cheddar cheese",
                        "Bell pepper",
                        "Onion"
                ),
                "Cook eggs with peppers and onions. Place mixture and cheese "
                        + "inside tortilla. Cook until crispy."
        );


        //Banana Oatmeal
        Recipe bananaOatmeal = new Recipe(
                "Banana Oatmeal",
                "Breakfast",
                "Warm oatmeal topped with sliced bananas.",
                Arrays.asList(
                        "Oats",
                        "Milk",
                        "Banana",
                        "Cinnamon",
                        "Honey"
                ),
                "Cook oats with milk. Add sliced banana, cinnamon, and honey."
        );


        //Veggie Omelet
        Recipe veggieOmelet = new Recipe(
                "Veggie Omelet",
                "Breakfast",
                "Egg omelet filled with fresh vegetables and cheese.",
                Arrays.asList(
                        "Eggs",
                        "Bell pepper",
                        "Spinach",
                        "Onion",
                        "Cheddar cheese"
                ),
                "Cook vegetables in a skillet. Add beaten eggs. "
                        + "Fold omelet and add cheese."
        );


        //Yogurt and Granola Bowl
        Recipe yogurtBowl = new Recipe(
                "Yogurt Bowl",
                "Breakfast",
                "Creamy yogurt topped with granola and fresh fruit.",
                Arrays.asList(
                        "Greek yogurt",
                        "Granola",
                        "Strawberries",
                        "Blueberries",
                        "Honey"
                ),
                "Add yogurt to a bowl. Top with granola and fruit. "
                        + "Drizzle with honey."
        );


        //LUNCH OPTIONS:
        //Chicken Caesar Salad
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
                "Grill chicken. Chop lettuce. Combine ingredients "
                        + "and add Caesar dressing."
        );


        //Turkey and Cheese Sandwich
        Recipe turkeySandwich = new Recipe(
                "Turkey and Cheese Sandwich",
                "Lunch",
                "Classic turkey sandwich with cheese and fresh vegetables.",
                Arrays.asList(
                        "Bread",
                        "Turkey",
                        "Cheddar cheese",
                        "Lettuce",
                        "Tomato"
                ),
                "Layer turkey, cheese, lettuce, and tomato between two "
                        + "slices of bread."
        );


        //Grilled Chicken Wrap
        Recipe chickenWrap = new Recipe(
                "Grilled Chicken Wrap",
                "Lunch",
                "Grilled chicken wrapped with lettuce and vegetables.",
                Arrays.asList(
                        "Flour tortilla",
                        "Chicken breast",
                        "Lettuce",
                        "Tomato",
                        "Ranch dressing"
                ),
                "Grill chicken and slice into strips. Add chicken and "
                        + "vegetables to tortilla. Add dressing and wrap."
        );


        //Tomato Basil Pasta Salad
        Recipe pastaSalad = new Recipe(
                "Tomato Basil Pasta Salad",
                "Lunch",
                "Cold pasta salad with tomatoes, basil, and mozzarella.",
                Arrays.asList(
                        "Pasta",
                        "Tomatoes",
                        "Fresh basil",
                        "Mozzarella",
                        "Olive oil"
                ),
                "Cook pasta and let cool. Add tomatoes, basil, and mozzarella. "
                        + "Toss with olive oil."
        );


        //Chicken Teriyaki Bowl
        Recipe teriyakiBowl = new Recipe(
                "Chicken Teriyaki Bowl",
                "Lunch",
                "Grilled chicken served over rice with teriyaki sauce.",
                Arrays.asList(
                        "Chicken breast",
                        "Rice",
                        "Teriyaki sauce",
                        "Broccoli",
                        "Carrots"
                ),
                "Cook rice. Grill chicken and steam vegetables. "
                        + "Serve together with teriyaki sauce."
        );


        //Tuna Salad Sandwich
        Recipe tunaSandwich = new Recipe(
                "Tuna Salad Sandwich",
                "Lunch",
                "Creamy tuna salad served on toasted bread.",
                Arrays.asList(
                        "Tuna",
                        "Mayonnaise",
                        "Celery",
                        "Bread",
                        "Lettuce"
                ),
                "Mix tuna, mayonnaise, and celery. Spread onto bread "
                        + "and add lettuce."
        );


        //Caprese Sandwich
        Recipe capreseSandwich = new Recipe(
                "Caprese Sandwich",
                "Lunch",
                "Fresh mozzarella, tomato, and basil served on bread.",
                Arrays.asList(
                        "Bread",
                        "Mozzarella",
                        "Tomato",
                        "Fresh basil",
                        "Balsamic glaze"
                ),
                "Layer mozzarella, tomato, and basil on bread. "
                        + "Drizzle with balsamic glaze."
        );


        //Southwest Chicken Salad
        Recipe southwestSalad = new Recipe(
                "Southwest Chicken Salad",
                "Lunch",
                "Chicken salad with corn, beans, and southwest flavors.",
                Arrays.asList(
                        "Chicken breast",
                        "Lettuce",
                        "Black beans",
                        "Corn",
                        "Avocado"
                ),
                "Grill chicken and slice. Combine with lettuce, beans, "
                        + "corn, and avocado."
        );


        //Hummus Wrap
        Recipe hummusWrap = new Recipe(
                "Veggie Hummus Wrap",
                "Lunch",
                "Healthy wrap filled with hummus and fresh vegetables.",
                Arrays.asList(
                        "Flour tortilla",
                        "Hummus",
                        "Cucumber",
                        "Tomato",
                        "Spinach"
                ),
                "Spread hummus on tortilla. Add vegetables and spinach. "
                        + "Roll tightly and serve."
        );


        //DINNER OPTIONS:
        //Chicken Alfredo Pasta
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


        //Spaghetti and Meatballs
        Recipe spaghetti = new Recipe(
                "Spaghetti and Meatballs",
                "Dinner",
                "Classic spaghetti with tomato sauce and meatballs.",
                Arrays.asList(
                        "Spaghetti",
                        "Ground beef",
                        "Tomato sauce",
                        "Onion",
                        "Garlic"
                ),
                "Cook spaghetti. Prepare meatballs and tomato sauce. "
                        + "Combine sauce with pasta and serve."
        );


        //Chicken Tacos
        Recipe chickenTacos = new Recipe(
                "Chicken Tacos",
                "Dinner",
                "Seasoned chicken tacos topped with fresh vegetables.",
                Arrays.asList(
                        "Chicken breast",
                        "Tortillas",
                        "Lettuce",
                        "Tomato",
                        "Cheddar cheese"
                ),
                "Cook seasoned chicken. Warm tortillas. "
                        + "Fill tortillas with chicken and toppings."
        );


        //Beef Stir Fry
        Recipe beefStirFry = new Recipe(
                "Beef Stir Fry",
                "Dinner",
                "Tender beef cooked with colorful vegetables.",
                Arrays.asList(
                        "Beef",
                        "Bell pepper",
                        "Broccoli",
                        "Soy sauce",
                        "Rice"
                ),
                "Slice beef and vegetables. Stir fry beef and vegetables. "
                        + "Add soy sauce and serve over rice."
        );


        //Chicken Parmesan
        Recipe chickenParmesan = new Recipe(
                "Chicken Parmesan",
                "Dinner",
                "Breaded chicken topped with tomato sauce and melted cheese.",
                Arrays.asList(
                        "Chicken breast",
                        "Breadcrumbs",
                        "Tomato sauce",
                        "Mozzarella",
                        "Parmesan cheese"
                ),
                "Bread and cook chicken. Top with tomato sauce and cheese. "
                        + "Bake until cheese is melted."
        );


        //Shrimp Fried Rice
        Recipe shrimpFriedRice = new Recipe(
                "Shrimp Fried Rice",
                "Dinner",
                "Fried rice with shrimp, vegetables, and scrambled egg.",
                Arrays.asList(
                        "Shrimp",
                        "Rice",
                        "Eggs",
                        "Peas",
                        "Soy sauce"
                ),
                "Cook shrimp. Stir fry rice and vegetables. Add eggs and shrimp. "
                        + "Season with soy sauce."
        );

        //Garlic Chicken Pasta
        Recipe garlicChickenPasta = new Recipe(
                "Garlic Chicken Pasta",
                "Dinner",
                "Tender chicken and pasta tossed in a creamy garlic sauce.",
                Arrays.asList(
                        "Chicken",
                        "Pasta",
                        "Garlic",
                        "Cream",
                        "Parmesan"
                ),
                "Cook pasta according to package directions. Cook chicken with garlic, "
                        + "then add cream and Parmesan. Toss with pasta and serve."
        );


        //Pizza
        Recipe margheritaPizza = new Recipe(
                "Margherita Pizza",
                "Dinner",
                "Classic pizza topped with tomato, mozzarella, and basil.",
                Arrays.asList(
                        "Pizza dough",
                        "Tomato sauce",
                        "Mozzarella",
                        "Fresh basil",
                        "Olive oil"
                ),
                "Spread sauce on pizza dough. Add mozzarella and basil. "
                        + "Bake until crust is golden."
        );


        //Beef Crunchwrap
        Recipe beefCrunchwrap = new Recipe(
                "Beef Crunchwrap",
                "Dinner",
                "Seasoned beef, cheese, and fresh toppings wrapped in a crispy tortilla.",
                Arrays.asList(
                        "Ground beef",
                        "Flour tortillas",
                        "Cheese",
                        "Lettuce",
                        "Tomato"
                ),
                "Cook ground beef with taco seasoning. Add beef, cheese, lettuce, and tomato "
                        + "to a flour tortilla. Fold into a wrap and cook in a skillet until golden."
        );


       //Add recipes to recipe manager
        Recipe[] allRecipes = {
                pancakes,
                frenchToast,
                breakfastBurrito,
                scrambledEggs,
                waffles,
                avocadoToast,
                breakfastQuesadilla,
                bananaOatmeal,
                veggieOmelet,
                yogurtBowl,

                caesarSalad,
                turkeySandwich,
                chickenWrap,
                pastaSalad,
                teriyakiBowl,
                tunaSandwich,
                capreseSandwich,
                southwestSalad,
                hummusWrap,

                chickenAlfredo,
                spaghetti,
                chickenTacos,
                beefStirFry,
                chickenParmesan,
                shrimpFriedRice,
                garlicChickenPasta,
                margheritaPizza,
                beefCrunchwrap
        };


        // Add every recipe to the RecipeManager
        for (Recipe recipe : allRecipes) {
            manager.addRecipe(recipe);
        }


        //test recipes
        System.out.println("RecipeHub started!");

        System.out.println(
                "Number of recipes: "
                        + manager.getRecipes().size()
        );

        System.out.println("\nRecipes:");

        for (Recipe recipe : manager.getRecipes()) {
            System.out.println(
                    "- " + recipe.getName()
            );
        }


        //create emptly weekly meal plan
        MealPlan mealPlan = new MealPlan();


        //recipe graph
        RecipeGraph recipeGraph = new RecipeGraph();

        // Add all recipes to the graph
        for (Recipe recipe : allRecipes) {
            recipeGraph.addRecipe(recipe);
        }


        // Connect some related recipes
        // Breakfast connections
        recipeGraph.addConnection(
                pancakes,
                frenchToast
        );

        recipeGraph.addConnection(
                pancakes,
                waffles
        );

        recipeGraph.addConnection(
                scrambledEggs,
                breakfastBurrito
        );

        recipeGraph.addConnection(
                breakfastBurrito,
                breakfastQuesadilla
        );

        recipeGraph.addConnection(
                avocadoToast,
                veggieOmelet
        );

        recipeGraph.addConnection(
                bananaOatmeal,
                yogurtBowl
        );


        // Lunch connections
        recipeGraph.addConnection(
                caesarSalad,
                chickenWrap
        );

        recipeGraph.addConnection(
                chickenWrap,
                southwestSalad
        );

        recipeGraph.addConnection(
                turkeySandwich,
                tunaSandwich
        );

        recipeGraph.addConnection(
                pastaSalad,
                capreseSandwich
        );

        recipeGraph.addConnection(
                teriyakiBowl,
                southwestSalad
        );

        recipeGraph.addConnection(
                hummusWrap,
                capreseSandwich
        );


        // Dinner connections
        recipeGraph.addConnection(
                chickenAlfredo,
                garlicChickenPasta
        );

        recipeGraph.addConnection(
                chickenAlfredo,
                spaghetti
        );

        recipeGraph.addConnection(
                chickenAlfredo,
                chickenParmesan
        );

        recipeGraph.addConnection(
                spaghetti,
                chickenParmesan
        );

        recipeGraph.addConnection(
                spaghetti,
                margheritaPizza
        );

        recipeGraph.addConnection(
                chickenParmesan,
                margheritaPizza
        );

        recipeGraph.addConnection(
                chickenTacos,
                beefCrunchwrap
        );

        recipeGraph.addConnection(
                beefStirFry,
                shrimpFriedRice
        );


        //category tree
        CategoryTree categoryTree =
                new CategoryTree();

        // Add all recipes to category tree
        for (Recipe recipe : allRecipes) {
            categoryTree.addRecipeToCategory(recipe);
        }


        // Display category tree
        categoryTree.printTree();


        //recipehubgui
        SwingUtilities.invokeLater(() -> {

            RecipeHubGUI gui =
                    new RecipeHubGUI(
                            manager,
                            mealPlan,
                            recipeGraph,
                            categoryTree
                    );

            gui.setVisible(true);
        });
    }
}



