package com.example.notas.ui.theme.components

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notas.domain.notes.model.Note
import com.example.notas.ui.theme.NotasTheme

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    note: Note,
    onSelectedNote: (note: Note) -> Unit

    ){
    Card(modifier = Modifier.clickable { onSelectedNote(note) },  colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ),) {
    Column (modifier = Modifier.padding(10.dp)){
        Text(text = note.title, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
        Text(text = note.body, maxLines = 3, overflow = TextOverflow.Ellipsis)
    }
    }

}

@Composable
fun FakeNoteCard(){
    NotasTheme {
        NoteCard(note =Note(id= 0, title = "viaje", body = "-Alistar la comida\n- Alistar la ropa") , onSelectedNote ={} )
    }
}

@Preview
@Composable
fun NoteCardPreview(){
    FakeNoteCard()
}