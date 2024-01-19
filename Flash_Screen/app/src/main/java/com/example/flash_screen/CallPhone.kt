package com.example.flash_screen

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.net.toUri
import java.util.jar.Manifest

class CallPhone : AppCompatActivity(){
    private lateinit var etPhoneNumber : EditText
    private lateinit var btnBill : Button
    private lateinit var btnPhoneCall : Button
    private val permissionCode = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_phone)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        btnBill = findViewById(R.id.btnBill)
        btnPhoneCall = findViewById(R.id.btnPhoneCall)
        btnPhoneCall.setOnClickListener {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),permissionCode)
         } else {
            startCall()
         }
        }
        btnBill.setOnClickListener{
            if (ActivityCompat.checkSelfPermission(this,
                    android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),permissionCode)
            } else {
                val encode = Uri.encode("#")
                val bill = "*124$encode"
                val intentBill = Intent(Intent.ACTION_CALL)
                intentBill.data = Uri.parse("tel:$bill")
                startActivity(intentBill)
            }
        }
    }
    private fun startCall() {
        val phNumber = etPhoneNumber.text.toString()
        val intentCall = Intent(Intent.ACTION_CALL)
        if (phNumber.startsWith("09") || phNumber.startsWith("+959")) {
            intentCall.data = "tel:$phNumber".toUri()
            startActivity(intentCall)
        } else if (phNumber.isEmpty()) {
            Toast.makeText(this@CallPhone, "Please enter ph:number", Toast.LENGTH_SHORT).show()
        } else {
            intentCall.data = "tel:09$phNumber".toUri()
            startActivity(intentCall)
        }
    }
}