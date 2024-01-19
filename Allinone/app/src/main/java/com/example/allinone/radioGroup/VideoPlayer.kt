package com.example.allinone.radioGroup

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import androidx.core.net.toUri
import com.example.allinone.R

class VideoPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)
        val vide1 = findViewById<VideoView>(R.id.videoVideo1)
        val videoPath : Uri = "android.resources://com.example.allinone/${R.raw.video1}".toUri()
        vide1.setVideoURI(videoPath)
        val vController = android.widget.MediaController(this)
        vController.setAnchorView(vide1)
        vide1.setMediaController(vController)
        vide1.start()
    }
}