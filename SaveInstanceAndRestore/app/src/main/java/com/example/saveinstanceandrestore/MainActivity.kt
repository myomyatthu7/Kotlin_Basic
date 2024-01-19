package com.example.saveinstanceandrestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var count = 1
    var total : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bigToast("OnCreate")
    }
    override fun onResume() {
        super.onResume()
        total += count
        Log.i("Log","OnResume")
    }
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("Key",total)
        Log.i("Log","onSave")
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("Key")
        Toast.makeText(this,"$total",Toast.LENGTH_SHORT).show()
        Log.i("Log","OnRestore")
    }
    private fun bigToast(text : String) {
        Log.i("Log",text)
    }
    override fun onStart() {
        super.onStart()
        bigToast("onStart")
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