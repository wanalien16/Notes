package com.example.notes.domain

interface NoteRepository {
    suspend fun addNote(note: Note)
    suspend fun getAllNotes(): List<Note>

    suspend fun deleteNote(note: Note)

    suspend fun addVoice(voiceNote: VoiceNote)

    suspend fun deleteVoice(voiceNote: VoiceNote)

    suspend fun getAllVoiceNotes(): List<VoiceNote>
}