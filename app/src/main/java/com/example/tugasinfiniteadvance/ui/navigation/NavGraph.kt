package com.example.tugasinfiniteadvance.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasinfiniteadvance.ui.screens.home.SholatNowScreen
import com.example.tugasinfiniteadvance.ui.screens.profile.Profile
import com.example.tugasinfiniteadvance.ui.screens.regist.login.LoginScreen
import com.example.tugasinfiniteadvance.ui.screens.regist.signup.SignUpScreen
import com.example.tugasinfiniteadvance.ui.screens.welcome.WelcomeScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController(), @SuppressLint("ModifierParameter") modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "Welcome") {
        composable("SholatNow") { SholatNowScreen() }
        composable("Profile") { Profile() }
        composable("SignUp") { SignUpScreen(navController = navController) }
        composable("Login") { LoginScreen(navController = navController) }
        composable("Welcome") { WelcomeScreen(navController = navController) }
    }
}