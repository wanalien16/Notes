package com.example.notes.domain.usecases

import com.example.notes.domain.Note
import com.example.notes.domain.NoteRepository

class AddNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note){
        return repository.addNote(note)
    }
}