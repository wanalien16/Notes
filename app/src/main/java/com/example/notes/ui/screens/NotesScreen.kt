package com.example.notes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notes.domain.Note
import com.example.notes.ui.viewModels.NoteViewModel


@Composable
fun NotesScreen(viewModel: NoteViewModel = hiltViewModel()){
    val notes by viewModel.notes.collectAsState()
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
Column {
    TextField(value = title, onValueChange = {title = it})
    Spacer(modifier = Modifier.padding(5.dp))
    TextField(value = description, onValueChange = {description = it} )
    Button(onClick = { viewModel.addNote(Note(title = title, description = description))
    title = ""
    description = ""}) {
        Text(text = "Add Note")
    }
LazyColumn {
    items(notes){
        note -> Text("${note.title}: ${note.description}")
    }
}

}
}