package com.example.sharedpreference
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val getName = intent.getStringExtra("NAME")
        val getAge = intent.getIntExtra("AGE",0)
        tvName.text = getName
        tvAge.text = getAge.toString()
    }
}