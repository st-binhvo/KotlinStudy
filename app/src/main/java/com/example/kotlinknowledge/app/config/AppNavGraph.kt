package com.example.kotlinknowledge.app.config

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.kotlinknowledge.app.config.model.ScreenRoute
import com.example.kotlinknowledge.presentation.BottomNavigationView
import com.example.kotlinknowledge.presentation.authentication.LoginScreen
import com.example.kotlinknowledge.presentation.discover.SearchScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        route = "ROOT_GRAPH_ROUTE",
        startDestination = "MAIN_GRAPH_ROUTE",
    ) {
        navigation(
            route = "MAIN_GRAPH_ROUTE",
            startDestination = ScreenRoute.Login.route,
        ){
            composable(route = ScreenRoute.Login.route) {
                LoginScreen()
            }
            composable(route = ScreenRoute.BottomNavigationRoute.route,) {
                BottomNavigationView(
                    goToSearchScreen = {
                        navController.navigate(ScreenRoute.Search.route)
                    }
                )
            }
        }
        composable(route = ScreenRoute.Search.route,) {
            SearchScreen()
        }
    }
}


