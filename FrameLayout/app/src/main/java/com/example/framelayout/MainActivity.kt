package com.example.framelayout

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import java.time.LocalDateTime
import java.util.function.LongFunction
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnOne : Button
    private lateinit var btnTwo : Button
    private lateinit var btnThree : Button
    private lateinit var linearOne : LinearLayout
    private lateinit var linearTwo : LinearLayout
    private lateinit var linearThree : LinearLayout
    private lateinit var btnStart : Button
    private lateinit var btnStop : Button
    private lateinit var customLibs : CustomLibs
    private lateinit var tvDate : TextView
    private lateinit var tvTime : TextView
    private lateinit var tvResult : TextView
    private var start : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("dt","onCreate")
        setUpUi()
    }
    @SuppressLint("NewApi")
    private fun setUpUi() {
        customLibs = CustomLibs(this@MainActivity)
        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnTwo)
        btnThree = findViewById(R.id.btnThree)
        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)
        linearOne =findViewById(R.id.linearOne)
        linearTwo =findViewById(R.id.linearTwo)
        linearThree =findViewById(R.id.linearThree)
        tvDate =findViewById(R.id.tvDate)
        tvTime =findViewById(R.id.tvTime)
        tvResult =findViewById(R.id.tvResult)

        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnStart.setOnClickListener(this)
        btnStop.setOnClickListener(this)
    }
    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnOne -> {
                linearOne.visibility = View.VISIBLE
                linearTwo.visibility = View.INVISIBLE
                linearThree.visibility = View.INVISIBLE
            }
            R.id.btnTwo -> {
                linearOne.visibility = View.INVISIBLE
                linearTwo.visibility = View.VISIBLE
                linearThree.visibility = View.INVISIBLE
            }
            R.id.btnThree -> {
                linearOne.visibility = View.INVISIBLE
                linearTwo.visibility = View.INVISIBLE
                linearThree.visibility = View.VISIBLE
            }
            R.id.btnStart -> {
                 customLibs.playSound()
                 start = System.currentTimeMillis()
            }
            R.id.btnStop -> {
                customLibs.pauseSound()
                 val stop : Long = System.currentTimeMillis()
                 val milli: Long= stop - start
                val second : Int = (milli/1000).toInt()
                val min : Int = second/60
                val hr : Int = min/12
                tvResult.text = "Result :$min/$second/$milli"
            }
        }
    }
    override fun onResume() {
        super.onResume()
        Log.i("dt","onResume")
        val dateTime = customLibs.getDateTime()
        val date :String  = dateTime.substring(0,dateTime.indexOf(" "))
        val time : String = dateTime.substring(dateTime.indexOf(" "),dateTime.length)
        tvDate.text = date
        tvTime.text = time
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("dt", "onRestart")
    }
    override fun onPause() {
        super.onPause()
        Log.i("dt","onPause")
        customLibs.pauseSound()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("dt","onSave")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("dt","onRestore")
    }
}
