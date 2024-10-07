package com.example.notes.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.Note
import com.example.notes.domain.usecases.AddNoteUseCase
import com.example.notes.domain.usecases.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(private val addNoteUseCase: AddNoteUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase): ViewModel() {
        private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes : StateFlow<List<Note>> get() = _notes

    fun addNote(note: Note){
        viewModelScope.launch {
            addNoteUseCase(note)
        }
    }

    fun loadNotes(){
        viewModelScope.launch {
            _notes.value = getAllNotesUseCase()
        }
    }
}