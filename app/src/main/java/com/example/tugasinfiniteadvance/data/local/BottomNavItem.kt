package com.example.tugasinfiniteadvance.data.local

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val screenRoute: String,
    val selectedColor: Color = Color.Green,
    val unselectedColor: Color = Color.Gray
)