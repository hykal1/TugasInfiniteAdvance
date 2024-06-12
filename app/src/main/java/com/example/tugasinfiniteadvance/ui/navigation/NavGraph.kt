package com.example.tugasinfiniteadvance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasinfiniteadvance.ui.screens.home.SholatNow
import com.example.tugasinfiniteadvance.ui.screens.profile.Profile

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "SholatNow") {
        composable("SholatNow") { SholatNow() }
        composable("Profile") { Profile() }
    }
}