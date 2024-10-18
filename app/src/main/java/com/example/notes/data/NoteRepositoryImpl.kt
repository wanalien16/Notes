package com.example.notes.data

import com.example.notes.domain.Note
import com.example.notes.domain.NoteRepository

class
NoteRepositoryImpl(private val noteDao: NoteDao): NoteRepository {
    override suspend fun addNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes()
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

}