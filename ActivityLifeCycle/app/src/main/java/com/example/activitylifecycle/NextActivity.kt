package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        bigToast("next onCreate")
        val btnFinish = findViewById<Button>(R.id.btnFinish)
        btnFinish.setOnClickListener {
            finish()
        }
    }
    private fun bigToast(text : String) {
        Log.i("Log",text)
    }

    override fun onStart() {
        super.onStart()
        bigToast("next onStart")
    }
    override fun onResume() {
        super.onResume()
        bigToast("next OnResume")
    }
    override fun onPause() {
        super.onPause()
        bigToast("next onPause")
    }
    override fun onStop() {
        super.onStop()
        bigToast("next onStop\n")
    }
    override fun onRestart() {
        super.onRestart()
        bigToast("next onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        bigToast("next onDestroy\n")
    }
}