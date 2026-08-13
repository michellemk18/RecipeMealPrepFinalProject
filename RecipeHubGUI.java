import javax.swing.*;
import java.awt.*;
import java.util.List;

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
                        "RecipeHub- Final Data Structures Project",
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


    // add to weekly meal plan
    private void showAddMealDialog(Recipe recipe) {

        // Days available for the meal plan
        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        // Ask the user which day they want
        String selectedDay =
                (String) JOptionPane.showInputDialog(
                        this,
                        "Choose a day for "
                                + recipe.getName()
                                + ":",
                        "Add to Meal Plan",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        days,
                        days[0]
                );

        // If the user clicked Cancel
        if (selectedDay == null) {
            return;
        }

        // Add the recipe to the selected day
        mealPlan.addMeal(
                selectedDay,
                recipe
        );

        // Tell the user it worked
        JOptionPane.showMessageDialog(
                this,
                recipe.getName()
                        + " added to "
                        + selectedDay
                        + "!",
                "Meal Plan",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // Related Recipes
    private void showRelatedRecipes(Recipe recipe) {

        JFrame relatedFrame =
                new JFrame(
                        "RecipeHub - Related Recipes"
                );

        relatedFrame.setSize(600, 500);

        relatedFrame.setLocationRelativeTo(this);

        relatedFrame.setLayout(
                new BorderLayout()
        );

        //header panel
        JPanel header =
                new JPanel();

        header.setBackground(
                new Color(45, 55, 72)
        );

        JLabel title =
                new JLabel(
                        "🔗 Related to "
                                + recipe.getName()
                );

        title.setForeground(
                Color.WHITE
        );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        header.add(title);

        relatedFrame.add(
                header,
                BorderLayout.NORTH
        );

        //related recipes panel
        JPanel recipesPanel =
                new JPanel();

        recipesPanel.setBackground(
                new Color(245, 247, 250)
        );

        recipesPanel.setLayout(
                new GridLayout(
                        0,
                        1,
                        10,
                        10
                )
        );

        recipesPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        30,
                        20,
                        30
                )
        );

        // Get related recipes from the graph
        List<Recipe> relatedRecipes =
                recipeGraph.getRelatedRecipes(
                        recipe
                );

        // Add each related recipe
        for (Recipe relatedRecipe :
                relatedRecipes) {

            JButton recipeButton =
                    createButton(
                            relatedRecipe.getName()
                    );

            recipeButton.addActionListener(e ->
                    showRecipeDetails(
                            relatedRecipe
                    )
            );

            recipesPanel.add(
                    recipeButton
            );
        }

        //no results
        if (relatedRecipes.isEmpty()) {

            JLabel noResults =
                    new JLabel(
                            "No related recipes found.",
                            SwingConstants.CENTER
                    );

            noResults.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            16
                    )
            );

            recipesPanel.add(
                    noResults
            );
        }

        relatedFrame.add(
                new JScrollPane(
                        recipesPanel
                ),
                BorderLayout.CENTER
        );

        //close button
        JButton closeButton =
                createButton("Close");

        closeButton.addActionListener(e ->
                relatedFrame.dispose()
        );

        JPanel bottomPanel =
                new JPanel();

        bottomPanel.add(
                closeButton
        );

        relatedFrame.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        relatedFrame.setVisible(true);
    }


    // SEARCH
    private void showSearchRecipes() {

        JFrame searchFrame = new JFrame("RecipeHub - Search Recipes");

        searchFrame.setSize(800, 600);
        searchFrame.setLocationRelativeTo(this);
        searchFrame.setLayout(new BorderLayout());

        //Top search panel
        JPanel searchPanel = new JPanel(new FlowLayout());

        JLabel searchLabel = new JLabel("Search:");

        JTextField searchField = new JTextField(25);

        JButton searchButton = createButton("Search");

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        searchFrame.add(
                searchPanel,
                BorderLayout.NORTH
        );

        // results panel
        DefaultListModel<Recipe> listModel =
                new DefaultListModel<>();

        JList<Recipe> resultsList =
                new JList<>(listModel);

        JScrollPane scrollPane =
                new JScrollPane(resultsList);

        searchFrame.add(
                scrollPane,
                BorderLayout.CENTER
        );

        //search button
        searchButton.addActionListener(e -> {

            String searchText =
                    searchField.getText();

            listModel.clear();

            List<Recipe> results =
                    recipeManager.searchRecipes(searchText);

            for (Recipe recipe : results) {

                listModel.addElement(recipe);
            }


            if (results.isEmpty()) {

                JOptionPane.showMessageDialog(
                        searchFrame,
                        "No recipes found.",
                        "Search",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        //close button
        JButton closeButton =
                createButton("Close");

        closeButton.addActionListener(e ->
                searchFrame.dispose()
        );

        JPanel bottomPanel =
                new JPanel();

        bottomPanel.add(closeButton);

        searchFrame.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

// Double click a recipe to view the full recipe
        resultsList.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            java.awt.event.MouseEvent e) {

                        if (e.getClickCount() == 2) {

                            Recipe selectedRecipe =
                                    resultsList.getSelectedValue();

                            if (selectedRecipe != null) {

                                showRecipeDetails(selectedRecipe);
                            }
                        }
                    }
                }
        );

        searchFrame.setVisible(true);
    }


    // FAVORITES
    private void showFavorites() {

        JFrame favoritesFrame =
                new JFrame("RecipeHub - Favorites");

        favoritesFrame.setSize(800, 600);
        favoritesFrame.setLocationRelativeTo(this);
        favoritesFrame.setLayout(new BorderLayout());

        //header panel
        JPanel header = new JPanel();

        header.setBackground(
                new Color(45, 55, 72)
        );

        JLabel title =
                new JLabel("❤️ Favorite Recipes");

        title.setForeground(Color.WHITE);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        header.add(title);

        favoritesFrame.add(
                header,
                BorderLayout.NORTH
        );

        //faves panel
        JPanel favoritesPanel =
                new JPanel();

        favoritesPanel.setBackground(
                new Color(245, 247, 250)
        );

        favoritesPanel.setLayout(
                new GridLayout(
                        0,
                        2,
                        20,
                        20
                )
        );

        favoritesPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        25,
                        25,
                        25
                )
        );

        // Get all favorite recipes
        for (Recipe recipe :
                recipeManager.getFavorites()) {

            JPanel recipeCard =
                    createRecipeCard(recipe);

            favoritesPanel.add(recipeCard);
        }

        //scroll bar for days of the week
        JScrollPane scrollPane =
                new JScrollPane(
                        favoritesPanel
                );

        scrollPane.setBorder(null);

        favoritesFrame.add(
                scrollPane,
                BorderLayout.CENTER
        );

       //close button
        JButton closeButton =
                createButton("Close");

        closeButton.addActionListener(e ->
                favoritesFrame.dispose()
        );

        JPanel bottomPanel =
                new JPanel();

        bottomPanel.add(closeButton);

        favoritesFrame.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        favoritesFrame.setVisible(true);
    }

    //Recommendations
    private void showRecommendations() {

        JFrame recommendationsFrame =
                new JFrame(
                        "RecipeHub - Recommendations"
                );

        recommendationsFrame.setSize(
                700,
                550
        );

        recommendationsFrame.setLocationRelativeTo(
                this
        );

        recommendationsFrame.setLayout(
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
                        "⭐ Recommended Recipes"
                );

        title.setForeground(
                Color.WHITE
        );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        header.add(title);

        recommendationsFrame.add(
                header,
                BorderLayout.NORTH
        );

        // RECOMMENDATIONS PANEL
        JPanel recommendationsPanel =
                new JPanel();

        recommendationsPanel.setBackground(
                new Color(245, 247, 250)
        );

        recommendationsPanel.setLayout(
                new GridLayout(
                        0,
                        2,
                        20,
                        20
                )
        );

        recommendationsPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        25,
                        25,
                        25
                )
        );

        // Get recommendations from graph
        List<Recipe> recommendations =
                recipeGraph.getRecommendations(
                        recipeManager.getFavorites()
                );

        // Display recommendations
        for (Recipe recipe :
                recommendations) {

            JPanel recipeCard =
                    createRecipeCard(recipe);

            recommendationsPanel.add(
                    recipeCard
            );
        }

        // NO RECOMMENDATIONS
        if (recommendations.isEmpty()) {

            JLabel noResults =
                    new JLabel(
                            "No recommendations yet.",
                            SwingConstants.CENTER
                    );

            noResults.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            16
                    )
            );

            recommendationsPanel.add(
                    noResults
            );
        }

        JScrollPane scrollPane =
                new JScrollPane(
                        recommendationsPanel
                );

        scrollPane.setBorder(null);

        recommendationsFrame.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // CLOSE BUTTON
        JButton closeButton =
                createButton("Close");

        closeButton.addActionListener(e ->
                recommendationsFrame.dispose()
        );

        JPanel bottomPanel =
                new JPanel();

        bottomPanel.add(
                closeButton
        );

        recommendationsFrame.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        recommendationsFrame.setVisible(true);
    }

    // Meal Plan
    private void showMealPlan() {

        JFrame mealPlanFrame =
                new JFrame("RecipeHub - Weekly Meal Plan");

        mealPlanFrame.setSize(700, 600);
        mealPlanFrame.setLocationRelativeTo(this);
        mealPlanFrame.setLayout(new BorderLayout());

        //header
        JPanel header =
                new JPanel();

        header.setBackground(
                new Color(45, 55, 72)
        );

        JLabel title =
                new JLabel("📅 Weekly Meal Plan");

        title.setForeground(Color.WHITE);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        header.add(title);

        mealPlanFrame.add(
                header,
                BorderLayout.NORTH
        );

        //Days panel
        JPanel daysPanel =
                new JPanel();

        daysPanel.setBackground(
                new Color(245, 247, 250)
        );

        daysPanel.setLayout(
                new GridLayout(
                        7,
                        1,
                        10,
                        10
                )
        );

        daysPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        30,
                        20,
                        30
                )
        );

        // Days of the week
        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        // Display each day
        for (String day : days) {

            Recipe recipe =
                    mealPlan.getMeal(day);

            JPanel dayPanel =
                    new JPanel(
                            new BorderLayout()
                    );

            dayPanel.setBackground(Color.WHITE);

            dayPanel.setBorder(
                    BorderFactory.createLineBorder(
                            new Color(220, 220, 220)
                    )
            );

            // Day name
            JLabel dayLabel =
                    new JLabel(day);

            dayLabel.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            16
                    )
            );

            dayLabel.setBorder(
                    BorderFactory.createEmptyBorder(
                            10,
                            10,
                            10,
                            10
                    )
            );

            dayPanel.add(
                    dayLabel,
                    BorderLayout.WEST
            );

            // Recipe name
            String mealText;

            if (recipe == null) {

                mealText = "No meal planned";

            } else {

                mealText = recipe.getName();
            }

            JLabel mealLabel =
                    new JLabel(mealText);

            mealLabel.setBorder(
                    BorderFactory.createEmptyBorder(
                            10,
                            10,
                            10,
                            10
                    )
            );

            dayPanel.add(
                    mealLabel,
                    BorderLayout.CENTER
            );

            daysPanel.add(dayPanel);
        }

        //scroll panel
        JScrollPane scrollPane =
                new JScrollPane(daysPanel);

        scrollPane.setBorder(null);

        mealPlanFrame.add(
                scrollPane,
                BorderLayout.CENTER
        );

        //buttons
        JButton undoButton =
                createButton("↩ Undo Last Meal");

        JButton closeButton =
                createButton("Close");

        // Undo button
        undoButton.addActionListener(e -> {

            if (mealPlan.canUndo()) {

                mealPlan.undoLastMeal();

                mealPlanFrame.dispose();

                showMealPlan();

            } else {

                JOptionPane.showMessageDialog(
                        mealPlanFrame,
                        "There are no meals to undo.",
                        "Undo",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // Close button
        closeButton.addActionListener(e ->
                mealPlanFrame.dispose()
        );

        JPanel bottomPanel =
                new JPanel();

        bottomPanel.add(undoButton);
        bottomPanel.add(closeButton);

        mealPlanFrame.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        mealPlanFrame.setVisible(true);
    }
}
