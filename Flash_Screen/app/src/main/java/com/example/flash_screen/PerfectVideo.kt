package com.example.flash_screen

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class PerfectVideo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfect_video)
        val videoPerfect = findViewById<VideoView>(R.id.videoPerfect)
        val filePath = "android.resource://com.example.flash_screen/${R.raw.perfect}"
        val uri = Uri.parse(filePath)
        videoPerfect.setVideoURI(uri)
        val controller = MediaController(this)
        controller.setAnchorView(videoPerfect)
        videoPerfect.setMediaController(controller)
        videoPerfect.start()
    }
}