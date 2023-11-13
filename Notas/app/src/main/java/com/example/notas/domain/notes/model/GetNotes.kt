package com.example.notas.domain.notes.model

import com.example.notas.data.notes.NoteRepository
import javax.inject.Inject

class GetNotes @Inject constructor(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(): List<Note>{
        return noteRepository.getAllNotes().map {it.toNote() }
    }
}