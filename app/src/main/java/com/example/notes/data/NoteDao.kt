package com.example.notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.notes.domain.Note
import com.example.notes.domain.VoiceNote

@Dao
interface NoteDao {
    @Insert
    fun insertNote(note: Note)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<Note>

    @Delete
    fun deleteNote(note: Note)

    @Insert
    fun insertVoice(voiceNote: VoiceNote)

    @Query("SELECT * FROM voiceNotes ORDER BY timestamp DESC")
    fun getAllVoices(): List<VoiceNote>

    @Delete
    fun deleteVoice(voiceNote: VoiceNote)
}