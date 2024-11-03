package com.example.notes.utils

import android.media.MediaRecorder
import java.io.File

class VoiceRecorder(private val outputFile: File) {
    private var mediaRecorder: MediaRecorder? = null

    fun startRecording(){
        mediaRecorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setOutputFile(outputFile.absolutePath)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            prepare()
            start()
        }
    }

    fun stopRecording(){
        mediaRecorder?.apply {
            stop()
            release()
        }
        mediaRecorder = null
    }
}