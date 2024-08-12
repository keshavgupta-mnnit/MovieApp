package com.atlys.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.atlys.movieapp.ui.screens.NavGraphs
import com.atlys.movieapp.ui.theme.ComposeProjectTheme

@Composable
fun AppNavigation() {
    ComposeProjectTheme(false) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = NavGraphs.main.route) {
            mainNavigation(navController)
        }
    }
}