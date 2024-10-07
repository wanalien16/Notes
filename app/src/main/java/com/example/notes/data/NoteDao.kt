package com.example.notes.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.notes.domain.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<Note>
}