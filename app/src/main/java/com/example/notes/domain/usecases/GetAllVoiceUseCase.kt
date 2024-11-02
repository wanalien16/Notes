package com.example.notes.domain.usecases

import com.example.notes.domain.NoteRepository
import com.example.notes.domain.VoiceNote
import javax.inject.Inject

class GetAllVoiceUseCase @Inject constructor(private val noteRepository: NoteRepository) {
    suspend operator fun invoke() : List<VoiceNote>{
        return noteRepository.getAllVoiceNotes()
    }

}