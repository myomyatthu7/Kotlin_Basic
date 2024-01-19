package com.example.flash_screen

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)
        val tvSlide = findViewById<TextView>(R.id.tvFlash)
        tvSlide.isSelected = true
        val media = MediaPlayer.create(this,R.raw.music)
        val thread = Thread {
            try {
                media.start()
                Thread.sleep(5000)
            } catch (e : InterruptedException) {
                e.printStackTrace()
            } finally {
                media.pause()
                val intent = Intent(this@FlashActivity,MainActivity::class.java)
                startActivity(intent)
            }
        }
        thread.start()
    }
}