package com.example.recipebookapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipebookapp.viewmodel.RecipeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, viewModel: RecipeViewModel, recipeId: Int) {
    val recipe = viewModel.getRecipeById(recipeId) ?: return

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(recipe.title) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.toggleFavorite(recipe.id) }) {
                        Icon(
                            imageVector = if (recipe.isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Toggle Favorite",
                            tint = if (recipe.isFavorite) MaterialTheme.colorScheme.primary else LocalContentColor.current
                        )
                    }
                }
            )

        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Ingredients", style = MaterialTheme.typography.titleMedium)
            recipe.ingredients.forEach {
                Text("• $it")
            }
            Spacer(Modifier.height(16.dp))

            Text("Steps", style = MaterialTheme.typography.titleMedium)
            recipe.steps.forEachIndexed { i, step ->
                Text("${i + 1}. $step")
            }

            Spacer(Modifier.height(24.dp))
            Button(
                onClick = { viewModel.toggleFavorite(recipe.id) },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(if (recipe.isFavorite) "Remove from Favorites" else "Add to Favorites")
            }
        }
    }
}
