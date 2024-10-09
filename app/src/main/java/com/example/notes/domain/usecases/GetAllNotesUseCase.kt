package com.example.notes.domain.usecases

import com.example.notes.domain.Note
import com.example.notes.domain.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(private val repository: NoteRepository) {
    suspend operator fun invoke(): List<Note>{
        return repository.getAllNotes()
    }

}