package com.example.videoplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fButtonMar = findViewById<TextView>(R.id.fButtonMar)
        val fButtonPer = findViewById<TextView>(R.id.fButtonPer)
        fButtonMar.setOnClickListener {
            val intent = Intent(this@MainActivity,MarVideo::class.java)
            startActivity(intent)
        }
        fButtonPer.setOnClickListener {
            val intent = Intent(this@MainActivity,PerVideo::class.java)
            startActivity(intent)
        }
    }
}