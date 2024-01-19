package com.example.datatransfer

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class GetData : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    private lateinit var tvEnter : TextView
    private lateinit var rgLanguage : RadioGroup
    private lateinit var tvChoose : TextView
    private lateinit var btnFinish : Button
    private lateinit var btnBack : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data)
        bigToast("Get onCreate")
        tvEnter = findViewById(R.id.tvEnter)
        rgLanguage = findViewById(R.id.rgLanguage)
        tvChoose = findViewById(R.id.tvChoose)
        btnFinish = findViewById(R.id.btnFinish)
        btnBack = findViewById(R.id.btnBack)
        val enterText = intent.getStringExtra("EnterText")
        tvEnter.text = enterText
        rgLanguage.setOnCheckedChangeListener(this)
        btnFinish.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            bigToast("Get BtnFinish")
            intent.putExtra("Choose",tvChoose.text)
            startActivity(intent)
            finish()
            //startNextMatchingActivity(intent)
            //finish()
        }
        btnBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            //finish()
        }
    }
    @SuppressLint("SetTextI18n")
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        bigToast("Get OnCheck")
        when(checkedId) {
            R.id.rbJava -> tvChoose.text = "You choose Java"
            R.id.rbKotlin -> tvChoose.text = "You choose Kotlin"
            R.id.rbJavaScript -> tvChoose.text = "You choose JavaScript"
            R.id.rbCPlus -> tvChoose.text = "You choose C++"
        }
    }
    private fun bigToast(text : String) {
        Log.i("Log",text)
    }

    override fun onStart() {
        super.onStart()
        bigToast("Get onStart")
    }
    override fun onResume() {
        super.onResume()
        bigToast("Get OnResume")
    }
    override fun onPause() {
        super.onPause()
        bigToast("Get onPause")
    }
    override fun onStop() {
        super.onStop()
        bigToast("Get onStop")
    }
    override fun onRestart() {
        super.onRestart()
        bigToast("Get onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        bigToast("Get onDestroy")
    }
}