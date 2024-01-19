package com.example.allinone.myLibrary

import android.content.Context
import android.widget.Toast

class CustomToast {
    fun toast(context: Context,message:String) {
        return Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }
}