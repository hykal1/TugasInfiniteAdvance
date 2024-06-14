package com.example.tugasinfiniteadvance.data.local

sealed class Screen(val route: String) {
    object Note : Screen("note")
    object Notes : Screen("addnote/{id}") {
        fun createRoute(id: Int?) = "addnote/$id"
    }
}