package com.example.notas.ui.theme.main.views

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notas.ui.theme.NotasTheme
import com.example.notas.ui.theme.components.NoteList
import com.example.notas.ui.theme.main.MainDestinations
import com.example.notas.ui.theme.main.interaction.NoteState
import com.example.notas.utils.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigate : (MainDestinations) -> Unit,
    noteState: NoteState
){

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {"Add"},
                icon = { androidx.compose.material3.Icon(Icons.Filled.Add,
                    contentDescription = "Add")},
                onClick = {onNavigate(MainDestinations.AddScreen)})
        }
    ) {
        NoteList(modifier = Modifier.padding(it),notes = noteState.notes , onSelectedNote = {})
    }
}

@Composable
fun fakeHomeScreen(){
    NotasTheme {
        HomeScreen(onNavigate = {}, noteState = NoteState())
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
        fakeHomeScreen()
}