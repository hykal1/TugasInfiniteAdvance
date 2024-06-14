package com.example.tugasinfiniteadvance.ui.screens.note

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tugasinfiniteadvance.data.local.Screen

fun NavGraphBuilder.NoteScreenRoute(navController: NavController) {
    composable(route = Screen.Note.route) {
        NoteScreen(navController)
    }
}