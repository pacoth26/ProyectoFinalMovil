package com.example.notas

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.notas.data.notes.local.NoteDao
import com.example.notas.data.notes.local.NoteDatabase
import com.example.notas.data.notes.model.NoteEntity
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class NoteDatabaseInstrumentedTest {
    private lateinit var noteDao: NoteDao
    private lateinit var db: NoteDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, NoteDatabase::class.java).build()
        noteDao = db.noteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeNoteAndReadAllNotes() {
    //Creamos una instancia NoteEntity
        val title = "viaje"
        val noteEntity = NoteEntity(uid= 1, title= title, body= "Alistar comida")

    //Insertamos la nota en la base de datos
    noteDao.insert(noteEntity = noteEntity)

    //Leer la base de datos
    val notes = noteDao.getAll()

    //Borramos la nota que insertamos en la base de datos
    noteDao.delete(noteEntity = noteEntity)

    // Mostramos la lista de notas de la consukta por consola
        println(notes)

    //Probamos si el resultado es el esperado
        assertEquals(notes[0].title, title)
    }
}