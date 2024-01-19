package com.example.flash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PlayVideo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)
        val tvMar = findViewById<TextView>(R.id.tvMar)
        val tvPerfect = findViewById<TextView>(R.id.tvPerfect)
        tvPerfect.setOnClickListener {
            val intentPer = Intent(this@PlayVideo,PerfectVideo::class.java)
            startActivity(intentPer)
        }
    }
}