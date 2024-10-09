package com.example.notes.domain

interface NoteRepository {
    suspend fun addNote(note: Note)
    suspend fun getAllNotes(): List<Note>
}