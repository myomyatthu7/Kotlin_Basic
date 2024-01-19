package com.example.test2

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
//Implicit Intent
//test orientation and portrait,landscape
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnJavaPoint = findViewById<Button>(R.id.btnJavaPoint)
        btnJavaPoint.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.javatpoint.com/kotlin-android-implicit-intent"))
            startActivity(intent)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == 1) {
            Toast.makeText(this,"Portrait",Toast.LENGTH_LONG).show()
        } else if (newConfig.orientation == 2) {
            Toast.makeText(this,"Landscape",Toast.LENGTH_LONG).show()
        }
    }
}