import javax.swing.*;
import java.awt.*;

public class RecipeHubGUI extends JFrame {

    private RecipeManager recipeManager;
    private MealPlan mealPlan;
    private RecipeGraph recipeGraph;
    private CategoryTree categoryTree;

    public RecipeHubGUI(
            RecipeManager recipeManager,
            MealPlan mealPlan,
            RecipeGraph recipeGraph,
            CategoryTree categoryTree) {

        this.recipeManager = recipeManager;
        this.mealPlan = mealPlan;
        this.recipeGraph = recipeGraph;
        this.categoryTree = categoryTree;

        setupWindow();
        createHomeScreen();
    }

    private void setupWindow() {

        setTitle("RecipeHub - Recipe & Weekly Meal Planner");

        setSize(1000, 700);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
    }

    private void createHomeScreen() {

        // HEADER
        JPanel header = new JPanel();

        header.setBackground(
                new Color(45, 55, 72)
        );

        header.setPreferredSize(
                new Dimension(1000, 90)
        );

        JLabel title =
                new JLabel("🍴 RecipeHub");

        title.setForeground(Color.WHITE);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        32
                )
        );

        header.add(title);

        add(
                header,
                BorderLayout.NORTH
        );


        // MAIN CONTENT
        JPanel content = new JPanel();

        content.setBackground(
                new Color(245, 247, 250)
        );

        content.setLayout(
                new BorderLayout(20, 20)
        );

        content.setBorder(
                BorderFactory.createEmptyBorder(
                        30, 40, 30, 40
                )
        );


        JLabel welcome =
                new JLabel(
                        "<html><h1>Welcome to RecipeHub!</h1>"
                                + "<p>Discover recipes and plan your week.</p>"
                                + "</html>"
                );

        welcome.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        18
                )
        );

        content.add(
                welcome,
                BorderLayout.NORTH
        );


        // BUTTON PANEL
        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setBackground(
                new Color(245, 247, 250)
        );

        buttonPanel.setLayout(
                new GridLayout(
                        2,
                        2,
                        20,
                        20
                )
        );


        JButton browseButton =
                createButton("🍽 Browse Recipes");

        JButton searchButton =
                createButton("🔍 Search Recipes");

        JButton favoritesButton =
                createButton("❤️ Favorites");

        JButton mealPlanButton =
                createButton("📅 Weekly Meal Plan");


        buttonPanel.add(browseButton);

        buttonPanel.add(searchButton);

        buttonPanel.add(favoritesButton);

        buttonPanel.add(mealPlanButton);


        content.add(
                buttonPanel,
                BorderLayout.CENTER
        );


        // FOOTER
        JLabel footer =
                new JLabel(
                        "RecipeHub • Java Data Structures Project",
                        SwingConstants.CENTER
                );

        footer.setForeground(
                new Color(100, 100, 100)
        );

        content.add(
                footer,
                BorderLayout.SOUTH
        );


        add(
                content,
                BorderLayout.CENTER
        );


        // BUTTON ACTIONS
        browseButton.addActionListener(e ->
                showBrowseRecipes()
        );

        searchButton.addActionListener(e ->
                showSearchRecipes()
        );

        favoritesButton.addActionListener(e ->
                showFavorites()
        );

        mealPlanButton.addActionListener(e ->
                showMealPlan()
        );
    }


    // CREATE BUTTON
    private JButton createButton(String text) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        button.setFocusPainted(false);

        button.setBackground(
                Color.WHITE
        );

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(220, 220, 220)
                )
        );

        return button;
    }


    // BROWSE RECIPES
    private void showBrowseRecipes() {

        JFrame browseFrame =
                new JFrame(
                        "RecipeHub - Browse Recipes"
                );

        browseFrame.setSize(
                900,
                650
        );

        browseFrame.setLocationRelativeTo(this);

        browseFrame.setLayout(
                new BorderLayout()
        );


        // HEADER
        JPanel header =
                new JPanel();

        header.setBackground(
                new Color(45, 55, 72)
        );

        JLabel title =
                new JLabel(
                        "🍽 Browse Recipes"
                );

        title.setForeground(
                Color.WHITE
        );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        header.add(title);
        JLabel sortingLabel =
                new JLabel("  • Sorted A-Z using Bubble Sort");

        sortingLabel.setForeground(Color.WHITE);

        sortingLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        header.add(sortingLabel);

        browseFrame.add(
                header,
                BorderLayout.NORTH
        );


        // RECIPE PANEL
        JPanel recipePanel =
                new JPanel();

        recipePanel.setBackground(
                new Color(245, 247, 250)
        );

        recipePanel.setLayout(
                new GridLayout(
                        0,
                        2,
                        20,
                        20
                )
        );

        recipePanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        25,
                        25,
                        25
                )
        );

//Recipes sorted alphabetically using Bubble Sort
        for (Recipe recipe :
                recipeManager.sortRecipesAlphabetically()) {

            JPanel recipeCard =
                    createRecipeCard(recipe);

            recipePanel.add(recipeCard);
        }


        JScrollPane scrollPane =
                new JScrollPane(
                        recipePanel
                );

        scrollPane.setBorder(null);

        browseFrame.add(
                scrollPane,
                BorderLayout.CENTER
        );


        // CLOSE BUTTON
        JButton closeButton =
                createButton("Close");

        closeButton.addActionListener(e ->
                browseFrame.dispose()
        );


        JPanel bottomPanel =
                new JPanel();

        bottomPanel.setBackground(
                new Color(245, 247, 250)
        );

        bottomPanel.add(closeButton);

        browseFrame.add(
                bottomPanel,
                BorderLayout.SOUTH
        );


        browseFrame.setVisible(true);
    }


    // RECIPE CARD
    private JPanel createRecipeCard(
            Recipe recipe) {

        JPanel card =
                new JPanel();

        card.setBackground(
                Color.WHITE
        );

        card.setLayout(
                new BorderLayout(
                        10,
                        10
                )
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 220, 220)
                        ),
                        BorderFactory.createEmptyBorder(
                                15,
                                15,
                                15,
                                15
                        )
                )
        );


        JLabel nameLabel =
                new JLabel(
                        recipe.getName()
                );

        nameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );


        JLabel categoryLabel =
                new JLabel(
                        "Category: "
                                + recipe.getCategory()
                );

        categoryLabel.setForeground(
                new Color(90, 90, 90)
        );


        JLabel descriptionLabel =
                new JLabel(
                        "<html>"
                                + recipe.getDescription()
                                + "</html>"
                );

        descriptionLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );


        JPanel infoPanel =
                new JPanel();

        infoPanel.setBackground(
                Color.WHITE
        );

        infoPanel.setLayout(
                new BoxLayout(
                        infoPanel,
                        BoxLayout.Y_AXIS
                )
        );


        infoPanel.add(nameLabel);

        infoPanel.add(
                Box.createVerticalStrut(5)
        );

        infoPanel.add(categoryLabel);

        infoPanel.add(
                Box.createVerticalStrut(10)
        );

        infoPanel.add(descriptionLabel);


        card.add(
                infoPanel,
                BorderLayout.CENTER
        );


        JButton viewButton =
                createButton(
                        "View Recipe"
                );

        viewButton.addActionListener(e ->
                showRecipeDetails(recipe)
        );


        card.add(
                viewButton,
                BorderLayout.SOUTH
        );


        return card;
    }


    // =========================
    // RECIPE DETAILS
    // =========================

    private void showRecipeDetails(
            Recipe recipe) {

        JFrame detailsFrame =
                new JFrame(
                        recipe.getName()
                );

        detailsFrame.setSize(
                700,
                600
        );

        detailsFrame.setLocationRelativeTo(this);

        detailsFrame.setLayout(
                new BorderLayout()
        );


        JLabel title =
                new JLabel(
                        recipe.getName(),
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        title.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        20,
                        10,
                        20
                )
        );


        detailsFrame.add(
                title,
                BorderLayout.NORTH
        );


        // RECIPE INFORMATION
        JPanel information =
                new JPanel();

        information.setLayout(
                new BoxLayout(
                        information,
                        BoxLayout.Y_AXIS
                )
        );

        information.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        30,
                        10,
                        30
                )
        );


        JLabel category =
                new JLabel(
                        "Category: "
                                + recipe.getCategory()
                );

        category.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );


        JLabel description =
                new JLabel(
                        "<html><b>Description:</b><br>"
                                + recipe.getDescription()
                                + "</html>"
                );


        StringBuilder ingredientsText =
                new StringBuilder(
                        "<html><b>Ingredients:</b><br>"
                );


        for (String ingredient :
                recipe.getIngredients()) {

            ingredientsText.append(
                    "• "
                            + ingredient
                            + "<br>"
            );
        }


        ingredientsText.append(
                "</html>"
        );


        JLabel ingredients =
                new JLabel(
                        ingredientsText.toString()
                );


        JLabel instructions =
                new JLabel(
                        "<html><b>Instructions:</b><br>"
                                + recipe.getInstructions()
                                + "</html>"
                );


        information.add(category);

        information.add(
                Box.createVerticalStrut(15)
        );

        information.add(description);

        information.add(
                Box.createVerticalStrut(15)
        );

        information.add(ingredients);

        information.add(
                Box.createVerticalStrut(15)
        );

        information.add(instructions);


        detailsFrame.add(
                new JScrollPane(information),
                BorderLayout.CENTER
        );


        // BUTTONS
        JPanel buttons =
                new JPanel();


        JButton favoriteButton =
                createButton(
                        recipeManager.isFavorite(recipe)
                                ? "❤️ Remove Favorite"
                                : "❤️ Add Favorite"
                );


        favoriteButton.addActionListener(e -> {

            recipeManager.toggleFavorite(recipe);

            favoriteButton.setText(
                    recipeManager.isFavorite(recipe)
                            ? "❤️ Remove Favorite"
                            : "❤️ Add Favorite"
            );
        });


        JButton mealButton =
                createButton(
                        "📅 Add to Meal Plan"
                );


        mealButton.addActionListener(e ->
                showAddMealDialog(recipe)
        );


        JButton relatedButton =
                createButton(
                        "🔗 Related Recipes"
                );


        relatedButton.addActionListener(e ->
                showRelatedRecipes(recipe)
        );


        JButton closeButton =
                createButton("Close");


        closeButton.addActionListener(e ->
                detailsFrame.dispose()
        );


        buttons.add(favoriteButton);

        buttons.add(mealButton);

        buttons.add(relatedButton);

        buttons.add(closeButton);


        detailsFrame.add(
                buttons,
                BorderLayout.SOUTH
        );


        detailsFrame.setVisible(true);
    }


    // ADD TO MEAL PLAN
    private void showAddMealDialog(
            Recipe recipe) {

        JOptionPane.showMessageDialog(
                this,
                "Meal planning for "
                        + recipe.getName()
                        + " coming next!",
                "Meal Plan",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // RELATED RECIPES
    private void showRelatedRecipes(
            Recipe recipe) {

        JOptionPane.showMessageDialog(
                this,
                "Related recipes for "
                        + recipe.getName()
                        + " coming next!",
                "Related Recipes",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // SEARCH
    private void showSearchRecipes() {

        JOptionPane.showMessageDialog(
                this,
                "Search screen coming next!",
                "Search Recipes",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // FAVORITES
    private void showFavorites() {

        JOptionPane.showMessageDialog(
                this,
                "Favorites screen coming next!",
                "Favorites",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // MEAL PLAN
    private void showMealPlan() {

        JOptionPane.showMessageDialog(
                this,
                "Weekly Meal Plan screen coming next!",
                "Weekly Meal Plan",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}