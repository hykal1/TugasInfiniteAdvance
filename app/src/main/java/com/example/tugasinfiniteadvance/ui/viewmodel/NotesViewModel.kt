package com.example.tugasinfiniteadvance.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasinfiniteadvance.data.Entity.PrayEntity
import com.example.tugasinfiniteadvance.domain.repository.PrayRepository
import com.example.tugasinfiniteadvance.ui.screens.addnote.AddNoteEvent
import com.example.tugasinfiniteadvance.ui.screens.addnote.AddNoteState
import com.example.tugasinfiniteadvance.ui.screens.home.getNextPrayerTime
import com.example.tugasinfiniteadvance.ui.screens.note.NoteState
import com.google.firebase.storage.TaskState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class NotesViewModel @Inject constructor(
    private val prayRepository: PrayRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AddNoteState())
    val state = _state.asStateFlow()

    fun onEvent(event: AddNoteEvent) {
        when (event) {

            is AddNoteEvent.OnDescriptionChange -> _state.update {
                it.copy(
                    description = event.description
                )
            }


            is AddNoteEvent.OnTitleChange -> _state.update {
                it.copy(
                    title = event.title
                )
            }

            is AddNoteEvent.OnGetNoteById -> fetchNote(event.id)
        }
    }

    fun saveNote(noteEntity: PrayEntity) = viewModelScope.launch {
        prayRepository.upsertPray(
            prayEntity = noteEntity
        )
    }

    fun deleteNote(noteId: Int) = viewModelScope.launch {
        prayRepository.deletePrayById(noteId)
    }

    private fun fetchNote(noteId: Int) = viewModelScope.launch {
        prayRepository.getPrayById(noteId).collect { note ->
            _state.update {
                it.copy(
                    currentNoteId = note?.id,
                    title = note?.prayName ?: "",
                    description = note?.prayDescription ?: "",

                )
            }
        }
    }
}