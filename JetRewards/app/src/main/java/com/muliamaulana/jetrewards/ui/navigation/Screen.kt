package com.muliamaulana.jetrewards.ui.navigation

/**
 * Created by muliamaulana on 19/01/24.
 */

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
    object DetailReward: Screen("home/{rewardId}") {
        fun createRoute(rewardId: Long) = "home/$rewardId"
    }
}