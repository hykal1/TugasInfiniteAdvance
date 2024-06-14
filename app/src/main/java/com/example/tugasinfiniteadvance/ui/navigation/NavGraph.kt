package com.example.tugasinfiniteadvance.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasinfiniteadvance.data.local.Screen
import com.example.tugasinfiniteadvance.ui.screens.addnote.AddNoteScreen
import com.example.tugasinfiniteadvance.ui.screens.addnote.AddNoteScreenRoute
import com.example.tugasinfiniteadvance.ui.screens.home.SholatNowScreen
import com.example.tugasinfiniteadvance.ui.screens.note.NoteScreen
import com.example.tugasinfiniteadvance.ui.screens.note.NoteScreenRoute
import com.example.tugasinfiniteadvance.ui.screens.profile.UserProfileScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    Scaffold() { innerPading ->
        NavHost(
            navController = navController,
            startDestination = "SholatNow",
            modifier = Modifier.padding(innerPading)
        ) {
            composable("SholatNow") { SholatNowScreen() }
            composable("Profile") { UserProfileScreen() }
            composable("note") { NoteScreen(navController) }
            composable("Note") { NoteScreenRoute(navController) }
            AddNoteScreenRoute(navController)
        }
    }
}
