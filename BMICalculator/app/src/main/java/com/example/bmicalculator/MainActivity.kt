package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edWeight = findViewById<EditText>(R.id.edWeight)
        val edHeight = findViewById<EditText>(R.id.edHeight)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val tvRange = findViewById<TextView>(R.id.tvRange)
        val btnOffer = findViewById<Button>(R.id.btnOffer)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        btnOffer.setOnClickListener {
            val intent = Intent(this,Offer::class.java)
            startActivity(intent)
        }
        btnCalculate.setOnClickListener {
                val weight = edWeight?.text.toString()
                val height = edHeight?.text.toString()
                    try {
                        val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))
                        val bmi2Digit = String.format("%.2f", bmi).toFloat()
                        tvResult.text = bmi2Digit.toString()
                        displayResult(bmi2Digit)
//            val normalRange = "Normal range is Between 18.5 and 25"
//            tvRange.text = normalRange
                        tvRange.visibility = VISIBLE
                    } catch (e: Exception) {
                        Log.i("E",e.message.toString())
                        nullMessage()
                    }
            }
    }
    private lateinit var tvMessage : TextView
    private fun displayResult(bmi : Float) {
        tvMessage = findViewById<TextView>(R.id.tvMessage)
        val uW3 by lazy {
            "Very severely underweight"
        }
        val uW2 by lazy {
            "Severely underweight"
        }
        val uW1 by lazy {
            "Underweight"
        }
        val normal by lazy {
            "Healthy weight"
        }
        val oW by lazy {
            "Overweight"
        }
        val o1 by lazy {
            "Moderately obese"
        }
        val o2 by lazy {
            "Severely obese"
        }
        val o3 by lazy {
            "Very severely obese"
        }
        var colour = 0
         when(bmi) {
            in 0.0..15.0 -> {
                tvMessage.text = uW3
            }
            in 15.0..16.0 -> {
                tvMessage.text = uW2
                colour = R.color.underWeight
            }
            in 16.0..18.5 -> {
                tvMessage.text = uW1
                colour = R.color.underWeight
            }
            in 18.5..25.0 -> {
                tvMessage.text = normal
                colour = R.color.normal
            }
            in 25.0..30.0 -> {
                tvMessage.text = oW
                colour = R.color.overWeight
            }
            in 30.0..35.0 -> {
                tvMessage.text = o1
                colour = R.color.obese
            }
            in 35.0..40.0 -> {
                tvMessage.text = o2
                colour = R.color.obese
            }
            else -> {
                tvMessage.text = o3
                colour = R.color.obese
            }
        }
        tvMessage.setTextColor(ContextCompat.getColor(this,colour))
    }
    private fun nullMessage() {
        Toast.makeText(this@MainActivity,"This BMI doesn't look right\n" +
                "Make sure the height and weight you entered are correct",Toast.LENGTH_LONG).show()
    }
}