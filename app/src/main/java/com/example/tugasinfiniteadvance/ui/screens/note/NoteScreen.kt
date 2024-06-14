package com.example.tugasinfiniteadvance.ui.screens.note

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tugasinfiniteadvance.R
import com.example.tugasinfiniteadvance.data.Entity.PrayEntity
import com.example.tugasinfiniteadvance.data.local.Screen
import com.example.tugasinfiniteadvance.ui.viewmodel.NoteViewModel


@Composable
fun NoteScreen(
    navController : NavController,
    modifier: Modifier = Modifier,
    noteViewModel: NoteViewModel = viewModel(),
    listState: LazyListState = rememberLazyListState()
){
    val state by noteViewModel.state.collectAsState()
    val isFABExpanded by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 } }

    NoteContent(
        notes = state.notes,
        isFABExpanded = isFABExpanded,
        navController = navController,
        onFabClicked = { navController.navigate(Screen.Notes.createRoute(0))
        },
        modifier = modifier,
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteContent(
    notes: List<PrayEntity>,
    isFABExpanded: Boolean,
    navController: NavController,
    onFabClicked: () -> Unit,
    modifier: Modifier = Modifier) {
    Box() {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Image(
                            painter = painterResource(R.drawable.icon_waktu_sholat),
                            contentDescription = "Icon",
                            modifier = Modifier.width(140.dp)
                        )
                    }
                )
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = onFabClicked,
                    icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "Add") },
                    text = { Text(text = "Add Note") },
                    expanded = isFABExpanded
                )
            },
            modifier = modifier
        ) { contentPadding ->
            if (notes.isEmpty())
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(contentPadding)
                        .padding(16.dp)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(R.drawable.logo),
                        contentDescription = "Note Image",
                        modifier = Modifier.height(200.dp)
                    )
                }
            else
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = modifier.padding(contentPadding)
                ) {
                    items(notes, key = { it.id ?: 0 }) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            NoteCard(
                                title = it.prayName,
                                onItemTaskClicked = {
                                    navController.navigate(
                                        Screen.Notes.createRoute(
                                            it.id
                                        )
                                    )
                                }
                            )
                        }
                    }
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteContent( notes = emptyList(), isFABExpanded = false, navController = NavController(LocalContext.current), onFabClicked = {})
}