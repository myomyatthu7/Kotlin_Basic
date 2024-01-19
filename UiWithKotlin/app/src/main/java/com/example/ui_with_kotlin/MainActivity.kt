package com.example.ui_with_kotlin
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculator = findViewById<Button>(R.id.btnCalculator)
        val btnAni = findViewById<Button>(R.id.btnAni)
        val btnCart = findViewById<Button>(R.id.btnCart)
        btnCalculator.setOnClickListener {
            val intentCal = Intent(this@MainActivity,Calculator::class.java)
            startActivity(intentCal)
        }
        btnAni.setOnClickListener {
            val intentAni = Intent(this@MainActivity,Animation::class.java)
            startActivity(intentAni)
        }
        btnCart.setOnClickListener {
            val intentAniCart = Intent(this@MainActivity,Cart::class.java)
            startActivity(intentAniCart)
        }
    }
}