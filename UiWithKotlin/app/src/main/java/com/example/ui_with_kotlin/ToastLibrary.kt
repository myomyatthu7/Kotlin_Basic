package com.example.ui_with_kotlin

import android.content.Context
import android.view.Gravity
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

class ToastLibrary {
    fun bigToast(content: Context,text : String) {
        val toast = Toast.makeText(content,text,Toast.LENGTH_LONG)
        toast.show()

    }
}