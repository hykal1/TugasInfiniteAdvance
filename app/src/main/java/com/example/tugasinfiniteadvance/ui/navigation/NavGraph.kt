package com.example.tugasinfiniteadvance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasinfiniteadvance.ui.screens.home.SholatNowScreen
import com.example.tugasinfiniteadvance.ui.screens.profile.UserProfileScreen
import com.example.tugasinfiniteadvance.ui.screens.splash.SplashScreen
import com.example.tugasinfiniteadvance.ui.screens.welcome.WelcomeScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    /*NavHost(navController = navController, startDestination = "SholatNow") {
        composable("SholatNow") { SholatNowScreen() }
        composable("Profile") { UserProfileScreen() }
    }*/
    NavHost(navController = navController, startDestination = "splash", modifier = modifier) {
        composable("splash") { SplashScreen(navController = navController) }
        composable("welcome") { WelcomeScreen(navController = navController) }
        composable("SholatNow") { SholatNowScreen() }
        composable("Profile") { UserProfileScreen() }
    }
}