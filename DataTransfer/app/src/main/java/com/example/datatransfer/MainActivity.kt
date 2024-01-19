package com.example.datatransfer

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var fabPlay : FloatingActionButton
    private lateinit var fabPause : FloatingActionButton
    private lateinit var etEnter : EditText
    private lateinit var btnEnter : Button
    private lateinit var tvGetChoose : TextView
    lateinit var mp : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bigToast("onCreate")
        fabPlay = findViewById(R.id.fabPlay)
        fabPause = findViewById(R.id.fabPause)
        tvGetChoose = findViewById(R.id.tvGetChoose)
        fabPlay.setOnClickListener {
            Toast.makeText(this@MainActivity,"Make",Toast.LENGTH_SHORT).show()
            mp = MediaPlayer.create(this,R.raw.music1)
            mp.start()
            fabPlay.visibility = View.INVISIBLE
            fabPause.visibility = View.VISIBLE
        }
        fabPause.setOnClickListener{
            mp.release()
            fabPlay.visibility = View.VISIBLE
            fabPause.visibility = View.INVISIBLE
        }
        etEnter = findViewById(R.id.etEnter)
        btnEnter = findViewById(R.id.btnEnter)
        btnEnter.setOnClickListener {
            bigToast("btnEnter")
            val enterText = etEnter.text.toString()
            val intent = Intent(this,GetData::class.java)
            intent.putExtra("EnterText",enterText)
            startActivity(intent)
            finish()
        }
        val language = intent.getStringExtra("Choose")
        tvGetChoose.text = language
    }
    private fun bigToast(text : String) {
        Log.i("Log",text)
    }

    override fun onStart() {
        super.onStart()
        bigToast("onStart")
    }
    override fun onResume() {
        super.onResume()
        bigToast("OnResume")
    }
    override fun onPause() {
        super.onPause()
        bigToast("onPause")
    }
    override fun onStop() {
        super.onStop()
        bigToast("onStop\n")
    }
    override fun onRestart() {
        super.onRestart()
        bigToast("onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        bigToast("onDestroy\n")
    }
}