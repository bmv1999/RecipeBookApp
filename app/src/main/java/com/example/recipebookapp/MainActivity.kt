package com.example.recipebookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipebookapp.navigation.Screen
import com.example.recipebookapp.ui.screens.DetailsScreen
import com.example.recipebookapp.ui.screens.FavoritesScreen
import com.example.recipebookapp.ui.screens.HomeScreen
import com.example.recipebookapp.viewmodel.RecipeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                RecipeApp()
            }
        }
    }
}

@Composable
fun RecipeApp(viewModel: RecipeViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController, viewModel)
        }
        composable(Screen.Details.route,
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getInt("recipeId") ?: 0
            DetailsScreen(navController, viewModel, recipeId)
        }
        composable(Screen.Favorites.route) {
            FavoritesScreen(navController, viewModel)
        }
    }
}
