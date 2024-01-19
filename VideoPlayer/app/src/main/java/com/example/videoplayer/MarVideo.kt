package com.example.videoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.core.net.toUri

class MarVideo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mar_video)
        val videoMar = findViewById<VideoView>(R.id.videoMar)
        val filePath = "android.resource://com.example.videoplayer/${R.raw.mar}".toUri()
        videoMar.setVideoURI(filePath)
        val controller = MediaController(this)
        controller.setAnchorView(videoMar)
        videoMar.setMediaController(controller)
        videoMar.start()
    }
}