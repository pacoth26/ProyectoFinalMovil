package com.example.notas.domain.notes.model

import com.example.notas.data.notes.NoteRepository
import javax.inject.Inject

class AddNote @Inject constructor(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note){
        noteRepository.insertNote(noteEntity = note.toNoteEntity())
    }
}