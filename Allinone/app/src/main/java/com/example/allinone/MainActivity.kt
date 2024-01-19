package com.example.allinone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.allinone.radioGroup.FlashScreen

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnBmi : Button
    lateinit var btnFlash : Button
    //private val intentLibs = IntentLibs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBmi = findViewById(R.id.btnBMI)
        btnFlash = findViewById(R.id.btnFlash)
        btnBmi.setOnClickListener(this)
        btnFlash.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v) {
            btnBmi -> {
                val intent =Intent(this@MainActivity,BMI_Calculator::class.java)
                startActivity(intent)
            }
            btnFlash -> {
                val intent = Intent(this@MainActivity, FlashScreen::class.java)
                startActivity(intent)
            }
        }
    }
}