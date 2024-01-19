package com.example.sharedpreference
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var txtName : EditText
    lateinit var txtAge : EditText
    private lateinit var btnNext : Button
    private lateinit var sp : SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private var enterName : String = ""
    private var enterAge = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtName = findViewById(R.id.etName)
        txtAge = findViewById(R.id.etAge)
        sp = getSharedPreferences("my_sp", MODE_PRIVATE)
        editor = sp.edit()
        btnNext = findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            if(txtName.text.isNotEmpty()||txtAge.text.isNotEmpty()) {
                Toast.makeText(this,"Enter btn",Toast.LENGTH_SHORT).show()
                enterName = txtName.text.toString()
                enterAge = txtAge.text.toString().toInt()
                val intent = Intent(this,MainActivity2::class.java)
//            val bd = Bundle()
//            bd.putString("dkfkl",enterName)
                intent.putExtra("NAME",enterName)
                intent.putExtra("AGE",enterAge)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Enter Text",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onPause() {
        super.onPause()
        val name = txtName.text
        val age = txtAge.text
        editor.apply {
//            if (name.isEmpty()||age.isEmpty()) {
//                Toast.makeText(this@MainActivity,"Enter Text",Toast.LENGTH_SHORT).show()
//            } else {
                putString("sp_name",name.toString())
                putInt("sp_age",age.toString().toInt())
//            }
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