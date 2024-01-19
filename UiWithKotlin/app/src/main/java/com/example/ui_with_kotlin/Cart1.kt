package com.example.ui_with_kotlin

import android.content.res.AssetManager
import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.nio.Buffer

class Cart1 : AppCompatActivity() {
    private var array = ArrayList(ArrayList<String>())
    private var stBuilder : StringBuilder = StringBuilder()
    private  var stBuilderFinal = StringBuilder()
    private lateinit var cbK50 : CheckBox
    private lateinit var cbNote11P : CheckBox
    private lateinit var cbNote11eP : CheckBox
    private lateinit var cbNote11E : CheckBox
    private lateinit var cbNote114g : CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_cart)
        cbK50 = findViewById<CheckBox>(R.id.cbK50)
        cbNote11P = findViewById<CheckBox>(R.id.cbNote11P)
        cbNote11eP = findViewById<CheckBox>(R.id.cbNote11eP)
        cbNote11E = findViewById<CheckBox>(R.id.cbNote11E)
        cbNote114g = findViewById<CheckBox>(R.id.cbNote114g)
        twoDimentionalArray()
        //fileReading()
    }
    fun twoDimentionalArray() {
        fileReading()
        val stBuilderArray : List<String> = stBuilder.toString().split("\n")
        array = ArrayList(ArrayList(stBuilderArray))
        var t =0
        for (row in stBuilderArray.iterator()) {
            array[t++] = row.split(",").toString()
        }
        var z = 0
        var list : List<String>? = null
        for (col in array) {
            array[z++] = col.split("==").toString()
        }
        ToastLibrary().bigToast(this,array[0][1].toString())
    }
    private fun fileReading() {
        //var displayData : String = ""
        //val asM = assets
        try {
            val inputStream = assets.open("test.txt")
            val bufferReader = BufferedReader(InputStreamReader(inputStream))
            var line : String
            while (bufferReader.readLine().also { line = it } != null) {
                stBuilder.append(line+"\n")
            }
        } catch(e : Exception) {
            e.printStackTrace()
        }
        //ToastLibrary().bigToast(this@Cart1,stBuilder.toString())
    }
}