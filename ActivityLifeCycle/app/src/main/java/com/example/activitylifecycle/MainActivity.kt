package com.example.activitylifecycle

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.RelativeLayout as AndroidWidgetRelativeLayout

class MainActivity : AppCompatActivity() {
    lateinit var etText : EditText
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bigToast("onCreate")
        val btnNext = findViewById<Button>(R.id.btnAnotherActivity)
        val btnPhoneCall = findViewById<Button>(R.id.btnPhoneCall)
        etText = findViewById(R.id.etText)
        btnNext.setOnClickListener {
            val intent = Intent(this,NextActivity::class.java)
            startActivity(intent)
        }
        btnPhoneCall.setOnClickListener {
            bigToast("Btn clicked")
        }
    }
    private fun bigToast(text : String) {
        Log.i("Log",text)
    }

    override fun onStart() {
        super.onStart()
        bigToast("onStart")
    }
    override fun onResume() {
        super.onResume()
        bigToast("OnResume")
        count++
    }
    override fun onPause() {
        super.onPause()
        bigToast("onPause")
    }
    override fun onStop() {
        super.onStop()
        bigToast("onStop\n")
    }
    override fun onRestart() {
        super.onRestart()
        bigToast("onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        bigToast("onDestroy\n")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        bigToast("onSaveInstanceState")
        outState.putInt("Key",count)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        bigToast("onRestoreInstanceState")
        count = savedInstanceState.getInt("Key")
        bigToast(count.toString())
    }
}
