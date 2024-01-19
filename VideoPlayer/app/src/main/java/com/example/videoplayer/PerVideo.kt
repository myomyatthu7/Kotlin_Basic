package com.example.videoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.core.net.toUri

class PerVideo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_per_video)
        val videoPer = findViewById<VideoView>(R.id.videoPer)
        val filepath = "android.resource://com.example.videoplayer/${R.raw.mar1}".toUri()
        videoPer.setVideoURI(filepath)
        val controller = MediaController(this)
        controller.setAnchorView(videoPer)
        videoPer.setMediaController(controller)
        videoPer.start()
    }
}