package com.example.flash_screen

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.net.toUri

class SendPicture : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_picture)
        val btnSendPic = findViewById<Button>(R.id.btnSendPic)
        btnSendPic.setOnClickListener {
            val pic = "android.resource://com.example.flash_screen/drawable/${R.drawable.pic}"
            val uri = Uri.parse(pic)
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_STREAM,uri)
            intent.putExtra(Intent.EXTRA_TEXT,"Hello Kotlin")
            intent.type = "image/*"
            startActivity(intent)
        }
    }
}