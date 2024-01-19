package com.example.allinone.radioGroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.allinone.R

class RadioGroup : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    private lateinit var rg : RadioGroup
    private lateinit var rbtCall : RadioButton
    private lateinit var rbtGmail : RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_group)
        rbtCall = findViewById(R.id.rbtCall)
        rbtGmail = findViewById(R.id.rbtGmail)
        rg = findViewById(R.id.rg)
        rg.setOnCheckedChangeListener(this)

    }
    private fun <T>intent(java: Class<T>) {
        val intent = Intent(this@RadioGroup,java)
        startActivity(intent)
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(checkedId) {
            R.id.rbtCall -> intent(Call::class.java)
            R.id.rbtGmail -> intent(Gmail::class.java)
            R.id.rbtVideo -> intent(VideoPlayer::class.java)
        }
    }
}