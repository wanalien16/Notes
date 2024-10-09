package com.example.notes.domain.usecases

import com.example.notes.domain.Note
import com.example.notes.domain.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note){
        return repository.addNote(note)
    }
}