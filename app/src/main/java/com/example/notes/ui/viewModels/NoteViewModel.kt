package com.example.notes.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.Note
import com.example.notes.domain.VoiceNote
import com.example.notes.domain.usecases.AddNoteUseCase
import com.example.notes.domain.usecases.AddVoiceUseCase
import com.example.notes.domain.usecases.DeleteNoteUseCase
import com.example.notes.domain.usecases.DeleteVoiceUseCase
import com.example.notes.domain.usecases.GetAllNotesUseCase
import com.example.notes.domain.usecases.GetAllVoiceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(private val addNoteUseCase: AddNoteUseCase,
                                        private val deleteNoteUseCase: DeleteNoteUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val addVoiceUseCase: AddVoiceUseCase,
    private val deleteVoiceUseCase: DeleteVoiceUseCase,
    private val getAllVoiceUseCase: GetAllVoiceUseCase): ViewModel() {
        private val _notes = MutableStateFlow<List<Note>>(emptyList())
    private val _voiceNotes = MutableStateFlow<List<VoiceNote>>(emptyList())
    val notes : StateFlow<List<Note>> get() = _notes
    val voiceNotes: StateFlow<List<VoiceNote>> get() = _voiceNotes


    fun addNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            addNoteUseCase(note)
//            loadNotes()
        }
    }

     fun loadNotes(){
        viewModelScope.launch(Dispatchers.IO) {
            _notes.value = getAllNotesUseCase()
        }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            deleteNoteUseCase(note)
            loadNotes()

        }
    }

    fun addVoiceNote(voiceNote: VoiceNote){
        viewModelScope.launch(Dispatchers.IO) {
            addVoiceUseCase(voiceNote)
        }
    }

    fun deleteVoiceNote(voiceNote: VoiceNote){
        viewModelScope.launch(Dispatchers.IO) {
            deleteVoiceUseCase(voiceNote)
        }
    }

    fun loadVoiceNotes(){
        viewModelScope.launch(Dispatchers.IO) {
           _voiceNotes.value = getAllVoiceUseCase()
        }
    }

}