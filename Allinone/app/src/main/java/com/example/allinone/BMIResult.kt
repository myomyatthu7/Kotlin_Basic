package com.example.allinone

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class BMIResult : AppCompatActivity(), View.OnClickListener {
    private var count = 3000
    private lateinit var ivLike  : ImageView
    private lateinit var ivDislike  : ImageView
    private lateinit var btnLike  : Button
    private lateinit var btnUnlike  : Button
    private lateinit var tvCount  : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiresult)
        val tvNum = findViewById<TextView>(R.id.tvNum)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val tvRange = findViewById<TextView>(R.id.tvRange)
         ivLike = findViewById(R.id.ivLike)
         ivDislike = findViewById(R.id.ivDislike)
         btnLike = findViewById(R.id.btnLike)
         btnUnlike = findViewById(R.id.btnUnlike)
         tvCount = findViewById<Button>(R.id.tvCount)
        val num = intent.getStringExtra("num")
        val message = intent.getStringExtra("message")
        val range = intent.getStringExtra("range")
        tvNum.text = num
        tvMessage.text = message
        tvRange.text = range

        btnLike.setOnClickListener(this)
        btnUnlike.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when(v) {
            btnLike -> {
                count++
                tvCount.text = "$count:Like this page"
                ivLike.visibility = View.VISIBLE
                ivDislike.visibility = View.INVISIBLE
            }
            btnUnlike -> {
                count--
                tvCount.text = "$count:Unlike this page"
                ivLike.visibility = View.INVISIBLE
                ivDislike.visibility = View.VISIBLE
            }
        }
     }
}