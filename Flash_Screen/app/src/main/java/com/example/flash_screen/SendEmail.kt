package com.example.flash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.*
import kotlin.collections.ArrayList

class SendEmail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_email)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etSubject = findViewById<EditText>(R.id.etSubject)
        val etMessage = findViewById<EditText>(R.id.etMessage)
        val btnSend = findViewById<Button>(R.id.btnSend)

        val mail = etEmail.text
        val mails : Array<String> = mail.split(",").toTypedArray()
        val subject = etSubject.text
        val message = etMessage.text
        btnSend.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.CATEGORY_APP_EMAIL,mails)
            intent.putExtra(Intent.EXTRA_SUBJECT,subject)
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type = "plain/text"
            startActivity(intent)
        }
    }
}