package com.example.notas.domain.notes.model

import com.example.notas.data.notes.model.NoteEntity


data class Note(
    val id: Int,
    val title: String,
    val body: String
)
fun Note.toNoteEntity(): NoteEntity = NoteEntity(uid = id, title = title, body = body)
fun NoteEntity.toNote(): Note = Note(id = uid, title = title, body = body)