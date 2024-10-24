package com.example.notes.domain.usecases

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "voiceNotes")
data class VoiceNote(@PrimaryKey(autoGenerate = true) val id: Long = 0,
    val voice: String,
    val timestamp: Long = System.currentTimeMillis())
