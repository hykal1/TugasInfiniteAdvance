package com.example.tugasinfiniteadvance.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasinfiniteadvance.domain.repository.PrayRepository
import com.example.tugasinfiniteadvance.ui.screens.note.NoteState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel @Inject constructor(private val prayRepository: PrayRepository) : ViewModel() {
    private val _state = MutableStateFlow(NoteState())
    val state = _state.asStateFlow()

    init {
        getAllPrays()
    }
    private fun getAllPrays() = viewModelScope.launch (Dispatchers.IO) {
        prayRepository.getAllPrays().collect {
            notes -> _state.update {

                it.copy(notes = notes)}
        }
    }

}