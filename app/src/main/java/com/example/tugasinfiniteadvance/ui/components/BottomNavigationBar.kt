package com.example.tugasinfiniteadvance.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tugasinfiniteadvance.data.local.BottomNavItem

@Composable
fun BottomNavigationBar(navController: NavController, items: List<BottomNavItem>) {
    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { item ->
            val isSelected = currentRoute == item.screenRoute
            NavigationBarItem(
                selected = isSelected,
                onClick = { navController.navigate(item.screenRoute) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (isSelected) item.selectedColor else item.unselectedColor
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (isSelected) item.selectedColor else item.unselectedColor
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = item.selectedColor,
                    unselectedIconColor = item.unselectedColor,
                    selectedTextColor = item.selectedColor,
                    unselectedTextColor = item.unselectedColor
                )
            )
        }
    }
}