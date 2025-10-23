package com.example.recipebookapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.recipebookapp.model.Recipe

class RecipeViewModel : ViewModel() {

    private val _recipes = mutableStateListOf(
        Recipe(
            id = 1,
            title = "Spaghetti Carbonara",
            ingredients = listOf("Spaghetti", "Eggs", "Parmesan", "Bacon"),
            steps = listOf("Boil pasta", "Cook bacon", "Mix eggs and cheese", "Combine all"),
            imageRes = 0
        ),
        Recipe(
            id = 2,
            title = "Chicken Curry",
            ingredients = listOf("Chicken", "Curry Paste", "Coconut Milk", "Rice"),
            steps = listOf("Cook chicken", "Add paste", "Pour milk", "Simmer"),
            imageRes = 0
        ),
        Recipe(
            id = 3,
            title = "Pancakes",
            ingredients = listOf("Flour", "Milk", "Eggs", "Sugar"),
            steps = listOf("Mix ingredients", "Pour batter", "Cook both sides"),
            imageRes = 0
        )
    )

    val recipes: List<Recipe> get() = _recipes

    fun toggleFavorite(id: Int) {
        val index = _recipes.indexOfFirst { it.id == id }
        if (index != -1) {
            val recipe = _recipes[index]
            _recipes[index] = recipe.copy(isFavorite = !recipe.isFavorite)
        }
    }

    fun getRecipeById(id: Int): Recipe? = _recipes.find { it.id == id }
}
