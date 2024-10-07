package com.example.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.domain.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
