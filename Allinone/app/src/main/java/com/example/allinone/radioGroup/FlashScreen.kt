package com.example.allinone.radioGroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.allinone.R

class FlashScreen : AppCompatActivity() {
    lateinit var tvFlash : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_screen)
        tvFlash = findViewById(R.id.tvFlash)
        tvFlash.isSelected = true
        val thread = Thread {
            try {
                Thread.sleep(5000)
            }catch (e:Exception) {
                e.printStackTrace()
            }finally {
                val intent = Intent(this, RadioGroup::class.java)
                startActivity(intent)
            }
        }
        thread.start()
    }
}