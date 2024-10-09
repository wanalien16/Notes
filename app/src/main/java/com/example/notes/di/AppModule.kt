package com.example.notes.di

import android.content.Context
import androidx.room.Room
import com.example.notes.data.NoteDao
import com.example.notes.data.NoteDatabase
import com.example.notes.data.NoteRepositoryImpl
import com.example.notes.domain.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): NoteDatabase{
        return Room.databaseBuilder(context, NoteDatabase::class.java,"note_Database").build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(database: NoteDatabase) : NoteDao {
        return database.noteDao()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(dao: NoteDao): NoteRepository{
        return NoteRepositoryImpl(dao)
    }
}