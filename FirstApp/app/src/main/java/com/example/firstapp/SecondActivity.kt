package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i("Activity","SecondActivity : OnCreate")
        val tvSecond = findViewById<TextView>(R.id.tvSecond)
        val code = intent.getStringExtra("CODE")
        val message = "You will get free acc all the content for one month$code"
        tvSecond.text = message
        Log.i("Activity","SecondActivity : showMessage")
    }
    override fun onStart() {
        super.onStart()
        Log.i("Activity","SecondActivity : onStart")
    }
    override fun onPause() {
        super.onPause()
        Log.i("Activity","SecondActivity : onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Activity","SecondActivity : onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Activity","SecondActivity : onResume")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("Activity","SecondActivity : onDestroy")
    }
}