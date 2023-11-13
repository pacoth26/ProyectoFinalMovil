package com.example.notas.ui.theme.main.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notas.domain.notes.model.Note
import com.example.notas.ui.theme.NotasTheme
import com.example.notas.ui.theme.main.MainDestinations
import com.example.notas.ui.theme.main.interaction.NoteEvent
import com.example.notas.ui.theme.main.interaction.NoteState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(
    onEvent: (NoteEvent) -> Unit,
    noteState: NoteState,
    onNavigate : (MainDestinations) -> Unit
){
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    if (noteState.navToHome){
    onNavigate(MainDestinations.HomeScreen)
        onEvent(NoteEvent.NavToHome)
    }
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)) {
            TextField(
                modifier= Modifier.fillMaxWidth(),
                value = title,
                onValueChange ={newText-> title = newText},
                label = {Text("Title")}
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                modifier= Modifier.fillMaxWidth(),
                value = body,
                onValueChange ={newText-> body = newText},
                label = {Text("Body")}
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Button(onClick = {
                    onEvent(NoteEvent.Addnote(note = Note(id = 0, title = title, body = body)))
                }) {
                    Icon(
                        Icons.Filled.Done,
                        contentDescription ="Done",
                        modifier = Modifier.size(ButtonDefaults.IconSize) )
                }
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "")
            }
        }
    }
}

@Composable
fun FakeAddScreen(){
    NotasTheme {
        AddScreen(onEvent = {},NoteState(), onNavigate = {})
    }
}

@Preview
@Composable
fun AddScreenPreview(){
    FakeAddScreen()
}