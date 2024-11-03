package com.example.notes.ui.screens

import android.os.Environment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notes.domain.Note
import com.example.notes.ui.viewModels.NoteViewModel
import com.example.notes.utils.VoiceRecorder
import kotlinx.coroutines.launch
import java.io.File


@Composable
fun NotesScreen(viewModel: NoteViewModel = hiltViewModel(), onAddNoteClicked: () -> Unit){
//    val notes by viewModel.notes.collectAsState()
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }


    val outputDir = File(Environment.getExternalStorageDirectory(), "AudioNotes")
    if (!outputDir.exists()) outputDir.mkdirs()

    var isRecording by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val recorder = remember { mutableStateOf<VoiceRecorder?>(null) }

Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
    TextField(value = title, onValueChange = {title = it},label = { Text(text = "Note Title")})
    Spacer(modifier = Modifier.padding(5.dp))
    TextField(value = description, onValueChange = {description = it}, label = { Text(text = "Description")} )
    Spacer(modifier =Modifier.padding(15.dp))
    Button(onClick =  {viewModel.addNote(Note(title = title, description = description))
    title = ""
    description = ""}) {
        Text(text = "Add Note")
    }
    Spacer(modifier = Modifier.padding(5.dp))
    Button(onClick = {
        if (isRecording) {
            recorder.value?.stopRecording()
            isRecording = false
        } else {
            val filePath = "${outputDir.absolutePath}/note_${System.currentTimeMillis()}.3gp"
            val outputFile = File(filePath)
            recorder.value = VoiceRecorder(outputFile)
            recorder.value?.startRecording()
            coroutineScope.launch {
                viewModel.saveAudioNote(filePath, System.currentTimeMillis())
            }
            isRecording = true
        }
    }) {
        Text(if (isRecording) "Stop Recording" else "Start Recording")

    }
    Spacer(modifier = Modifier.padding(10.dp))

    Button(onClick =  onAddNoteClicked) {
        Text(text = "Get Notes")
    }
//LazyColumn {
//
//    items(notes){
//        note -> Text("${note.title}: ${note.description}")
//    }
//}

}
}