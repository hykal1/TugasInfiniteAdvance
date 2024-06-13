package com.example.tugasinfiniteadvance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasinfiniteadvance.ui.screens.home.SholatNowScreen
import com.example.tugasinfiniteadvance.ui.screens.profile.Profile
import com.example.tugasinfiniteadvance.ui.screens.regist.signup.SignUpScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "SignUp") {
        composable("SholatNow") { SholatNowScreen() }
        composable("Profile") { Profile() }
        composable("SignUp") { SignUpScreen() }
    }
}