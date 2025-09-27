package com.wil.dealarticleskmp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wil.dealarticleskmp.articles.ArticlesViewModel
import com.wil.dealarticleskmp.screens.AboutScreen
import com.wil.dealarticleskmp.screens.ArticlesScreen
import com.wil.dealarticleskmp.screens.Screen

@Composable
fun AppScaffold(
    viewModel: ArticlesViewModel
) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.ARTICLES.route
    ) {
        composable(Screen.ARTICLES.route) {
            ArticlesScreen(
                onAboutClick = { navController.navigate(Screen.ABOUT.route) },
                viewModel = viewModel
            )
        }
        composable(Screen.ABOUT.route) {
            AboutScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}