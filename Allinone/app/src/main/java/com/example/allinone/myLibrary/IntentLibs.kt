package com.example.allinone.myLibrary

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class IntentLibs : AppCompatActivity() {
    fun <T>intent(context: Context,clazz : Class<T>) {
        val intent = Intent(context,clazz)
        startActivity(intent)
    }
}