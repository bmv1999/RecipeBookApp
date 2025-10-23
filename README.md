# RecipeBookApp
- Name: Benjamin Vo
- CWID: 889378170
- Course: CPSC 411A Section 2

The RecipeBookApp project was built using: Jetpack Compose, ViewModel, and Navigation
The RecipeBookApp allows users to:
- Browse a list of recipes
- View detailed ingredients and preparation steps
- Mark or unmark recipes as favorites
- View all favorited recipes on a dedicated Favorites page

## Features
- Three main screens: Home, Details, and Favorites
- Updates when recipes are favorited/unfavorited
- Uses `mutableStateListOf` to store recipe data in a `ViewModel`
- Jetpack Navigation for screen transitions
- Material 3 Design for UI Design
- State management for favorites tracking

## Screens

### Home Screen
- Displays a list of recipes (title + ingredient count)
- Tap a recipe to open its details
- Includes a heart icon in the top bar to navigate to Favorites
<img width="362" height="798" alt="Screenshot 2025-10-22 230035" src="https://github.com/user-attachments/assets/0082c070-dc5e-43c5-9813-f80c4ddd963e" />

### Details Screen
- Shows recipe title, ingredients, and steps  
- Includes a heart icon to add/remove from favorites  
- Uses `toggleFavorite()` in the `RecipeViewModel` to update state
<img width="359" height="797" alt="Screenshot 2025-10-22 230102" src="https://github.com/user-attachments/assets/df068dbd-7341-4687-a07c-5329834853c9" />
<img width="358" height="799" alt="Screenshot 2025-10-22 230135" src="https://github.com/user-attachments/assets/6764f866-424a-4d37-b0fd-2b5d19f292eb" />  

### Favorites Screen
- Displays all recipes marked as favorite  
- Updates automatically when a recipe is favorited/unfavorited  
- Uses reactive state (`recipes.filter { it.isFavorite }`)
<img width="358" height="798" alt="Screenshot 2025-10-22 230211" src="https://github.com/user-attachments/assets/35dd9c09-01be-4f21-be52-c663c7b34308" />


