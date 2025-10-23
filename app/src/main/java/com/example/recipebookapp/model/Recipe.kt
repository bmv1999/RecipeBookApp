package com.example.recipebookapp.model

data class Recipe(
    val id: Int,
    val title: String,
    val ingredients: List<String>,
    val steps: List<String>,
    val imageRes: Int,
    val isFavorite: Boolean = false
)
