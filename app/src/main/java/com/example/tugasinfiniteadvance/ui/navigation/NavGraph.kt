package com.example.tugasinfiniteadvance.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasinfiniteadvance.SettingPreferences
import com.example.tugasinfiniteadvance.dataStore
import com.example.tugasinfiniteadvance.helper.ViewModelFactory
import com.example.tugasinfiniteadvance.ui.screens.home.SholatNowScreen
import com.example.tugasinfiniteadvance.ui.screens.profile.Profile
import com.example.tugasinfiniteadvance.ui.screens.regist.login.LoginScreen
import com.example.tugasinfiniteadvance.ui.screens.regist.signup.SignUpScreen
import com.example.tugasinfiniteadvance.ui.screens.welcome.WelcomeScreen
import com.example.tugasinfiniteadvance.ui.viewmodel.MainViewModel

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController(), @SuppressLint("ModifierParameter") modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val preferences = SettingPreferences.getInstance(context.dataStore)
    val viewModel: MainViewModel = viewModel(
        factory = ViewModelFactory(preferences)
    )

    val isLoggedIn by viewModel.getStatusLogin().observeAsState(initial = false)
    val startDestination = if (isLoggedIn) "SholatNow" else "Welcome"

    NavHost(navController = navController, startDestination = startDestination) {
        composable("SholatNow") { SholatNowScreen() }
        composable("Profile") { Profile() }
        composable("SignUp") { SignUpScreen(navController = navController) }
        composable("Login") { LoginScreen(navController = navController) }
        composable("Welcome") { WelcomeScreen(navController = navController) }
    }
}