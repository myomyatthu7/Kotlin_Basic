package com.example.allinone.radioGroup

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.allinone.myLibrary.CustomToast
import com.example.allinone.R

class Gmail : AppCompatActivity() {
    //private lateinit var binding : ActivityGmailBinding
    private lateinit var etAddress : EditText
    private lateinit var etSubject : EditText
    private lateinit var etMessage : EditText
    private lateinit var btnSent : Button
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityGmailBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_gmail)
        etAddress = findViewById(R.id.etAddress)
        etSubject = findViewById(R.id.etSubject)
        etMessage = findViewById(R.id.etMessage)
        btnSent = findViewById(R.id.btnSent)
        btnSent.setOnClickListener {
            sentMail(etAddress,etSubject,etMessage)
//            val email = etAddress.text.toString()
//            val subject = etSubject.text.toString()
//            val message = etMessage.text.toString()
//            val emails = email.split(",".toRegex()).toTypedArray()
//            val intent = Intent(Intent.ACTION_SENDTO).apply {
//                data = Uri.parse("mailto:")
//                putExtra(Intent.EXTRA_EMAIL,emails)
//                putExtra(Intent.EXTRA_SUBJECT,subject)
//                putExtra(Intent.EXTRA_TEXT,message)
//            }
//            if (intent.resolveActivity(packageManager) != null) startActivity(intent)
//            else {
//                CustomToast().toast(this@Gmail,"Required app isn't installed")
//            }
        }
    }
    @SuppressLint("QueryPermissionsNeeded")
    fun sentMail(address:EditText, sub:EditText, mes:EditText) {
        val mail = address.text.toString()
        val subject = sub.text.toString()
        val message = mes.text.toString()
        val mails = mail.split(",".toRegex()).toTypedArray()
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL,mails)
            putExtra(Intent.EXTRA_SUBJECT,subject)
            putExtra(Intent.EXTRA_TEXT,message)
        }
        if (intent.resolveActivity(packageManager) != null)
            startActivity(Intent.createChooser(intent,"Choose mail app"))
        else CustomToast().toast(this,"Required app isn't installed")
    }
}