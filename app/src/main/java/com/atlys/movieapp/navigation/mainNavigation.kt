package com.atlys.movieapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.atlys.movieapp.ui.screens.NavGraphs
import com.atlys.movieapp.ui.screens.destinations.MovieDetailsScreenDestination
import com.atlys.movieapp.ui.screens.destinations.MovieHomeScreenDestination
import com.atlys.movieapp.ui.screens.detailscreen.MovieDetailsScreen
import com.atlys.movieapp.ui.screens.homescreen.MovieHomeScreen
import com.ramcosta.composedestinations.utils.composable

fun NavGraphBuilder.mainNavigation(navController: NavController) {
    navigation(startDestination = MovieHomeScreenDestination.route, route = NavGraphs.main.route) {
        composable(MovieHomeScreenDestination) {
            MovieHomeScreen(destinationsNavigator(navController))
        }
        composable(MovieDetailsScreenDestination) {
            val args = navArgs.model
            MovieDetailsScreen(destinationsNavigator(navController),args)
        }

    }
}