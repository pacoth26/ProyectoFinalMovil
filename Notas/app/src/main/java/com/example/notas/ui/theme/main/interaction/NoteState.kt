package com.example.notas.ui.theme.main.interaction

import com.example.notas.domain.notes.model.Note

data class NoteState(
    var notes: List<Note> = emptyList(),
    var navToHome: Boolean = false
)
