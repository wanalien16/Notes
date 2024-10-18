package com.example.notes.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notes.domain.Note
import com.example.notes.ui.viewModels.NoteViewModel

@Composable
fun ListOfNotes(viewModel: NoteViewModel = hiltViewModel()){
viewModel.loadNotes()

    val notes by viewModel.notes.collectAsState()

    LazyColumn {
        items(notes){
            note-> NoteCardView(note)
        }
    }

}

@Composable
fun NoteCardView(note: Note){
    Card(modifier = Modifier.padding(10.dp).fillMaxSize()) {
        Column {
            Text(text = note.title)
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = note.description)
        }
    }


}