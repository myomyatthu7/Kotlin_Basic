package com.example.allinone.radioGroup

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.net.toUri
import com.example.allinone.myLibrary.CustomToast
import com.example.allinone.R

class Call : AppCompatActivity() {
    private lateinit var etCall : EditText
    private lateinit var btnCall : Button
    private lateinit var btnCheck : Button
    private val permissionCode = 10
    private val customToast = CustomToast()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        etCall = findViewById(R.id.etCall)
        btnCall = findViewById(R.id.btnCall)
        btnCheck = findViewById(R.id.btnBill)
        btnCall.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                 {
                     ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),permissionCode)
                } else {
                    startCall()
            }
        }
        btnCheck.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),permissionCode)
            } else {
                startBill()
            }
        }
    }

    private fun startBill() {
        val encode = Uri.encode("#")
        val bill = "*124$encode"
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$bill")
        startActivity(intent)
    }

    private fun startCall() {
        val number = etCall.text.toString()
        val intent = Intent(Intent.ACTION_CALL)
        if (number.startsWith("09")||number.startsWith("+959")) {
            intent.data = "tel:$number".toUri()
            startActivity(intent)
        } else if (number.isEmpty()) {
            customToast.toast(this@Call,"Add your ph number!!")
        } else {
            intent.data = "tel:09$number".toUri()
            startActivity(intent)
        }
    }
}