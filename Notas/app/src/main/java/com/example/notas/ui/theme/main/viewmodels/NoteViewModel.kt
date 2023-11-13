package com.example.notas.ui.theme.main.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notas.domain.notes.model.AddNote
import com.example.notas.domain.notes.model.EraseNote
import com.example.notas.domain.notes.model.GetNotes
import com.example.notas.domain.notes.model.Note
import com.example.notas.domain.notes.model.UpdateNote
import com.example.notas.ui.theme.main.interaction.NoteEvent
import com.example.notas.ui.theme.main.interaction.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNotes: GetNotes,
    private val addNote: AddNote,
    private val updateNote: UpdateNote,
    private val eraseNote: EraseNote
) : ViewModel() {

    private val _state : MutableState<NoteState> = mutableStateOf(NoteState())
    val state: State<NoteState> get() = _state

    init {
        collectNotes()
    }

     fun onEvent(noteEvent: NoteEvent){
        when(noteEvent){
            is NoteEvent.Addnote ->{
                onInsertNote(note = noteEvent.note)
            }

            NoteEvent.NavToHome -> {
                setNavToHome()
            }
            NoteEvent.NotNaveToHome -> {
                UnsetNavToHome()
            }
        }
    }

    private fun collectNotes(){
        viewModelScope.launch(Dispatchers.IO){
            val fetchedNotes = getNotes()
            withContext(Dispatchers.Main){
                _state.value = _state.value.copy(notes = fetchedNotes)
            }
        }
    }
    private fun onInsertNote(note : Note){
        viewModelScope.launch(Dispatchers.IO) {
            addNote(note = note)
            collectNotes()
            setNavToHome()
        }
    }
    private fun setNavToHome(){
        _state.value= _state.value.copy(navToHome = true)
    }
    private fun UnsetNavToHome(){
        _state.value= _state.value.copy(navToHome = false)
    }
}