package com.example.test1

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.Gravity
import android.widget.*
import kotlin.random.Random
import kotlin.random.nextUInt

class MainActivity : AppCompatActivity(){
    private lateinit var etEnter : EditText
    private lateinit var etCommand : EditText
    private lateinit var btnCommand : Button
    private lateinit var tgb : ToggleButton
    private lateinit var tvResult : TextView
    @SuppressLint("RtlHardcoded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInst anceState)
        setContentView(R.layout.activity_main)
        etEnter = findViewById(R.id.etEnter)
        etCommand = findViewById(R.id.etCommand)
        btnCommand = findViewById(R.id.btnCommand)
        tgb = findViewById(R.id.tgb)
        tvResult = findViewById(R.id.tvResult)
        val random = Random
        btnCommand.setOnClickListener {
            val enter = etEnter.text.toString()
            tvResult.text = enter
            tvResult.textSize = random.nextInt(70).toFloat()
            tvResult.setTextColor(rgb(random.nextInt(255),
                                    random.nextInt(255),
                                    random.nextInt(255)))
            when(random.nextInt(5)) {
                0 -> tvResult.gravity = Gravity.LEFT
                1 -> tvResult.gravity = Gravity.RIGHT
                2 -> tvResult.gravity = Gravity.CENTER
                3 -> tvResult.gravity = Gravity.CENTER_HORIZONTAL
                4 -> tvResult.gravity = Gravity.BOTTOM
            }
            val command = etCommand.text.toString()
            if (command.contentEquals("Left",true)) {
                tvResult.gravity = Gravity.LEFT
                //Toast.makeText(this,"Left",Toast.LENGTH_SHORT).show()
            } else if (command.contentEquals("Right",true)) {
                tvResult.gravity = Gravity.RIGHT
            }else if (command.contentEquals("Center",true)) {
                tvResult.gravity = Gravity.CENTER_HORIZONTAL
            }
        }
    }
}


