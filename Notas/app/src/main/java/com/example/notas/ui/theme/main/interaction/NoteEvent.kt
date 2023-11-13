package com.example.notas.ui.theme.main.interaction

import com.example.notas.domain.notes.model.Note

sealed class NoteEvent{
    object NavToHome : NoteEvent()
    object NotNaveToHome: NoteEvent()
    data class Addnote(val note : Note) : NoteEvent()
}
