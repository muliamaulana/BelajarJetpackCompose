package com.muliamaulana.resepmasak.ui.navigation

/**
 * Created by muliamaulana on 30/01/24.
 */

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("favorite")
    object About : Screen("about")
    object DetailRecipe : Screen("home/{recipeId}") {
        fun createRoute(recipeId: String?) = "home/$recipeId"
    }
}