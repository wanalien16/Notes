package com.example.notes.domain.usecases

import com.example.notes.domain.Note
import com.example.notes.domain.NoteRepository

class GetAllNotesUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(): List<Note>{
        return repository.getAllNotes()
    }
}