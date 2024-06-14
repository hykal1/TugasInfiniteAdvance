package com.example.tugasinfiniteadvance.ui.screens.addnote

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.tugasinfiniteadvance.data.Entity.PrayEntity
import com.example.tugasinfiniteadvance.ui.viewmodel.NotesViewModel
import java.time.Instant

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("new Api")
@Composable
fun AddNoteScreen(
    id: Int,
                  navController: NavController,
                  modifier: Modifier = Modifier,
                  context: Context = LocalContext.current,
                  noteViewModel: NotesViewModel = hiltViewModel()
) {
    val state by noteViewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(id) {
        noteViewModel.onEvent(AddNoteEvent.OnGetNoteById(id))
    }

//    TaskDatePicker(
//        state = datePickerState,
//        isOpen = state.isDatePickerDialogOpen,
//        onDismissRequest = { taskViewModel.isDatePickerDialogClosed() },
//        onConfirmButtonClicked = {
//            taskViewModel.onEvent(TaskEvent.OnDateChange(datePickerState.selectedDateMillis))
//            taskViewModel.isDatePickerDialogClosed()
//        }
//    )

    AddNoteContent(
        isNoteExist = state.currentNoteId != null,
        onBackClick = { navController.navigateUp() },
        onDeleteClick = {
            state.currentNoteId?.let { noteViewModel.deleteNote(it) }
            navController.navigateUp()
        },
        title = state.title,
        onTitleChange = { noteViewModel.onEvent(AddNoteEvent.OnTitleChange(it)) },
        description = state.description,
        onDescriptionChange = { noteViewModel.onEvent(AddNoteEvent.OnDescriptionChange(it)) },
        onSaveClick = {
            val note = PrayEntity(
                id = state.currentNoteId ?: 0,
                prayName = state.title,
                prayDescription = state.description,
            )

            if (state.title.isNotEmpty() && state.description.isNotEmpty()) {
                noteViewModel.saveNote(note)
                navController.navigateUp()
            } else
                Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT).show()
        },
        modifier = modifier
    )
}

@Composable
fun AddNoteContent(
    isNoteExist: Boolean,
    onBackClick: () -> Unit,
    onDeleteClick: () -> Unit,
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBarNote(
                isNoteExist = isNoteExist,
                onBackButtonClick = onBackClick,
                onDeleteButtonClick = onDeleteClick
            )
        },
        modifier = modifier
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxSize()
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = onTitleChange,
                label = { Text(text = "Title") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = description,
                onValueChange = onDescriptionChange,
                label = { Text(text = "Description") },
                modifier = Modifier.fillMaxWidth(),
            )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onSaveClick,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = "Save", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }