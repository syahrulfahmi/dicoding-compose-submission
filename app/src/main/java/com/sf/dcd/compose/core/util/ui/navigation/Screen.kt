package com.sf.dcd.compose.core.util.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("movie")
    object Detail : Screen("movie/{movieId}") {
        fun createRoute(movieId: Int) = "movie/$movieId"
    }
}
