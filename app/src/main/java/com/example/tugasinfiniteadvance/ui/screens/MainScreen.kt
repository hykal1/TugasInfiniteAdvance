package com.example.tugasinfiniteadvance.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tugasinfiniteadvance.R
import com.example.tugasinfiniteadvance.data.local.BottomNavItem
import com.example.tugasinfiniteadvance.ui.components.BottomNavigationBar
import com.example.tugasinfiniteadvance.ui.navigation.AppNavGraph

@Composable
fun MainScreen() {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val items = listOf(
        BottomNavItem(
            title = "SholatNow",
            icon = ImageVector.vectorResource(id = R.drawable.ic_home),
            screenRoute = "SholatNow",
            selectedColor = colorResource(id = R.color.green_selected),
            unselectedColor = colorResource(id = R.color.gray_unselected)
        ),
        BottomNavItem(
            title = "Profile",
            icon = ImageVector.vectorResource(id = R.drawable.ic_profile),
            screenRoute = "Profile",
            selectedColor = colorResource(id = R.color.green_selected),
            unselectedColor = colorResource(id = R.color.gray_unselected)
        )
    )

    Scaffold(
        bottomBar = {
            if (currentRoute != "SignUp") {
                BottomNavigationBar(navController = navController, items = items)
            }
        }
    ) {
        AppNavGraph(navController = navController, modifier = Modifier.padding(it))
    }
}