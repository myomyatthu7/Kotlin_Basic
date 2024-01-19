package com.example.firstapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.time.Duration

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btnSumit)
        val txtHello = findViewById<TextView>(R.id.tvHello)
        val txtName = findViewById<EditText>(R.id.tvName)
        //var timeClicked = 0
        button.setOnClickListener {
            Log.i("Main","Bottom was clicked")
            Toast.makeText(this,"Bottom clicked",Toast.LENGTH_SHORT).show()
            val name = txtName.text.toString()
            val message = "Hello $name"
            txtHello.text = message
        }
    }
}