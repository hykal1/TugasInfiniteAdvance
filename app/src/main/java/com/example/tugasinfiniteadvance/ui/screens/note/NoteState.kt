package com.example.tugasinfiniteadvance.ui.screens.note

import com.example.tugasinfiniteadvance.data.Entity.PrayEntity

data class NoteState(
    val notes: List<PrayEntity> = emptyList(),
) {
}