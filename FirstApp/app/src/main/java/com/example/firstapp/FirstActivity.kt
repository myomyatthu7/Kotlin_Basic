package com.example.firstapp

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Log.i("Activity","MainActivity : OnCreate")
        val btSubmit = findViewById<Button>(R.id.btSubmit)
        val edInput = findViewById<EditText>(R.id.edInput)
        val tvOutPut = findViewById<TextView>(R.id.tvOutPut)
        val tvReset = findViewById<TextView>(R.id.tvReset)
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val btnOffer = findViewById<Button>(R.id.btnOffer)
        var enterCode = ""
        btSubmit.setOnClickListener {
            enterCode = edInput.text.toString()
            tvOutPut.text = enterCode
            Log.i("Activity","MainActivity : Output")
            //val verify = edInput.text.toString()
            if (enterCode.isNotEmpty()) {
                if (enterCode == "12345") {
                    val welcome = "Welcome Sir"
                    tvWelcome.text = welcome
                    btnOffer.visibility = VISIBLE
                    btnOffer.setOnClickListener {
                        val intent = Intent(this@FirstActivity,SecondActivity::class.java)
                        intent.putExtra("CODE",enterCode)
                        startActivity(intent)
                    }
                } else {
                    Toast.makeText(this,"Code aren't correct",Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@FirstActivity,"Please enter your code",Toast.LENGTH_SHORT).show()
            }
        }
        tvReset.setOnClickListener {
            val black = null
            tvOutPut.text = black
            edInput.text.clear()
            btnOffer.visibility = INVISIBLE
        }
    }
    override fun onStart() {
        super.onStart()
        Log.i("Activity","MainActivity : onStart")
    }
    override fun onPause() {
        super.onPause()
        Log.i("Activity","MainActivity : onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Activity","MainActivity : onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Activity","MainActivity : onResume")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("Activity","MainActivity : onDestroy")
    }
}