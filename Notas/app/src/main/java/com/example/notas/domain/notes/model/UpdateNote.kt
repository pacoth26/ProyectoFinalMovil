package com.example.notas.domain.notes.model

import com.example.notas.data.notes.NoteRepository
import javax.inject.Inject

class UpdateNote @Inject constructor(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note){
        noteRepository.updateNote(noteEntity = note.toNoteEntity())
    }
}