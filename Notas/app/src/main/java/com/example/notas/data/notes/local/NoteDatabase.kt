package com.example.notas.data.notes.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notas.data.notes.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}