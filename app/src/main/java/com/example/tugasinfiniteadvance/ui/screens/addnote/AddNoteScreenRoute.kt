package com.example.tugasinfiniteadvance.ui.screens.addnote

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.tugasinfiniteadvance.data.local.Screen


fun NavGraphBuilder.AddNoteScreenRoute(navController: NavController) {
    composable(
        route = Screen.Notes.route,
        arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )
    ) {
        val noteId = it.arguments?.getInt("id", 0)
        AddNoteScreen(id = noteId ?: 0, navController)
    }
}