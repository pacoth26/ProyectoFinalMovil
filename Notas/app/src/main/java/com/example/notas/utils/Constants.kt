package com.example.notas.utils

import com.example.notas.domain.notes.model.Note

object Constants {
    const val note_database="note_db"
    const val note_table_name="note"

    val notes = listOf(
        Note(id= 0, title = "viaje", body = "-Alistar la comida\n- Alistar la ropa"),
        Note(id= 1, title = "examen", body = "-Tesis\n- Progra"),
        Note(id= 0, title = "Proyecto", body = "-Agrupar\n- Investigar"),
        Note(id= 0, title = "Fut", body = "-Entrenar\n- Marcaje"))
}