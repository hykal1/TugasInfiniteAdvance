package com.example.tugasinfiniteadvance.ui.screens.addnote

sealed interface AddNoteEvent {
    data class OnTitleChange(val title: String): AddNoteEvent
    data class OnDescriptionChange(val description: String): AddNoteEvent
    data class OnGetNoteById(val id: Int): AddNoteEvent
}