package com.example.notes.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
            note-> NoteCardView(note, onDeleteClicked = {viewModel.deleteNote(note)})
        }
    }

}

@Composable
fun NoteCardView(note: Note, onDeleteClicked: () -> Unit){
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {

                Text(text = note.title,  fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))

                IconButton(onClick = onDeleteClicked, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp)) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Note" )
                }
            }
            Text(text = note.description)
        }


    }


}