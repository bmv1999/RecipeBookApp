package com.example.recipebookapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details/{recipeId}") {
        fun createRoute(recipeId: Int) = "details/$recipeId"
    }
    object Favorites : Screen("favorites")
}
