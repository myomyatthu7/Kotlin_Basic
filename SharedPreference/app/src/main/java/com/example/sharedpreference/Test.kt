package com.example.sharedpreference

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class Test : AppCompatActivity() {
    lateinit var txtName : EditText
    lateinit var txtAge : EditText
    private lateinit var btnNext : Button
    private lateinit var sp : SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private var enterName : String? = null
    private var enterAge : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtName = findViewById(R.id.etName)
        txtAge = findViewById(R.id.etAge)
        sp = getSharedPreferences("my_sp", MODE_PRIVATE)
        editor = sp.edit()
        btnNext = findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            try {
                enterName = txtName.text.toString()
                enterAge = txtAge.text.toString().toInt()
            } catch (e: Exception) {
                Log.i("Exception", e.message.toString())
            }
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("Name",txtName.text.toString())
            intent.putExtra("Age",enterAge)
            startActivity(intent)
        }
    }
    override fun onPause() {
        super.onPause()
        try {
            val name = txtName.text
            val age = txtAge.text.toString()
            editor.apply {
                putString("sp_name",name.toString())
                putInt("sp_age",age.toInt())
                    .commit()
            }
        } catch (e: Exception) {
            Log.i("Exception",e.message.toString())
        }
    }
    override fun onResume() {
        super.onResume()
        val name = sp.getString("sp_name",null)
        val age = sp.getInt("sp_age",0)
        if (age != 0) {
            txtName.setText(name)
            txtAge.setText(age.toString())
        }
    }
}