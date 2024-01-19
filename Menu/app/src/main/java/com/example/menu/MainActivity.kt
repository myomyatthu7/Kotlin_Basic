package com.example.menu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.preference.PreferenceManager
import com.example.menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var tvName : TextView
    private lateinit var tvCheck : TextView
    private lateinit var tvSwitch : TextView
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        tvName = findViewById(R.id.tvName)
//        tvCheck = findViewById(R.id.tvCheck)
//        tvSwitch = findViewById(R.id.tvSwitch)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mySetting()
    }
    @SuppressLint("SetTextI18n")
    private fun mySetting() {
        val pm = PreferenceManager.getDefaultSharedPreferences(this)
        val name = pm.getString("name","")
        val cb = pm.getBoolean("checkb",false)
        val switch = pm.getBoolean("switch",true)
        binding.apply {
            tvName.text = name.toString()
            if (cb) {
                tvCheck.text = "CheckBox is on.."
            } else {
                tvCheck.text = "CheckBox is off.."
            }
            if (switch) {
                tvSwitch.text = "Now switch is on.."
            } else {
                tvSwitch.visibility = View.INVISIBLE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = MenuInflater(this)
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
        //return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.aboutUS -> {
                val intent1 = Intent(this,About::class.java)
                startActivity(intent1)
            }
            R.id.preference -> {
                val intent2 = Intent(this,SettingsActivity::class.java)
                startActivity(intent2)
            }
            R.id.exit -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}