package com.example.ui_with_kotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.animation.AnimationUtils

class Animation : Activity() {
    lateinit var ani : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        val btnOne = findViewById<Button>(R.id.btnOne)
        btnOne.setOnClickListener {
            Toast.makeText(this,"CLicked",Toast.LENGTH_SHORT).show()
        }
    }
}