package com.example.allinone

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import java.lang.NumberFormatException

class BMI_Calculator : AppCompatActivity() {
    private lateinit var etWeight : EditText
    private lateinit var etHeight : EditText
    private lateinit var tvNum : TextView
    private lateinit var tvMessage : TextView
    private lateinit var tvRange : TextView
    private lateinit var btnCal : Button
    private lateinit var btnHis : Button
    private lateinit var sp : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calculator)
        etHeight = findViewById(R.id.etHeight)
        etWeight = findViewById(R.id.etWeight)
        btnCal = findViewById(R.id.btnCal)
        btnHis = findViewById(R.id.btnHis)
        tvNum = findViewById(R.id.tvNum)
        tvRange = findViewById(R.id.tvRange)
        val height = etHeight.text.toString()
        val weight = etWeight.text.toString()
        btnCal.setOnClickListener {
            val bmi = weight.toFloat()/((height.toFloat()/100)*(height.toFloat()/100))
            val bmi2Digit = String.format("%.2f",bmi).toFloat()
            tvNum.text = bmi2Digit.toString()
            displayResult(bmi2Digit)
            tvRange.visibility = View.VISIBLE
        }
        btnHis.setOnClickListener {
            goToHistory()
        }
    }
//    private fun calculate(weight:Float,height:Float) {
//        try {
//
//        }catch (e:Exception) {
//            e.printStackTrace()
//            nullExp()
//        }
//        }
    private fun goToHistory() {
        try {
        val intent = Intent(this,BMIResult::class.java)
            .apply {
                    putExtra("num",tvNum.text)
                    putExtra("message",tvMessage.text)
                    putExtra("range",tvRange.text)
                }
            startActivity(intent)
            }catch (e:Exception) {
            e.printStackTrace()
            nullHistory()
        }
    }
    private fun displayResult(result : Float) {
        tvMessage = findViewById(R.id.tvMessage)
        var message = ""
        var colour  = 0
        when {
            result<15.0 -> {
                message = "Very severely underweight"
                colour  = R.color.under
            }
            result in 15.0..16.0 -> {
                message = "severely underweight"
                colour = R.color.under
            }
            result in 16.0..18.5 -> {
                message = "underweight"
                colour = R.color.under
            }
            result in 18.5..25.0 -> {
                message = "Normal"
                colour = R.color.normal
            }
            result in 25.0..30.0 -> {
                message= "overweight"
                colour = R.color.observe
            }
            result in 30.0..35.0 -> {
                message = "Moderately obese"
                colour = R.color.observe
            }
            result in 35.0..40.0 -> {
                message = "Severely obese"
                colour = R.color.observe
            }
            40 < result -> {
                message = "Very severely obese"
                colour = R.color.observe
            }
        }
        tvMessage.text = message
        tvMessage.setTextColor(ContextCompat.getColor(this,colour))
    }
    private fun nullExp() {
        Toast.makeText(this,"This BMI doesn't look right\n" +
                "Make sure the height and weight you entered are correct",Toast.LENGTH_SHORT).show()
    }
    private fun nullHistory() {
        Toast.makeText(this,"No history!",Toast.LENGTH_SHORT).show()
    }
}