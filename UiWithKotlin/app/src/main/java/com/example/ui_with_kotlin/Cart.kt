package com.example.ui_with_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBar
import java.io.InputStreamReader

class Cart : AppCompatActivity(), View.OnClickListener {
    private lateinit var cbK50 : CheckBox
    private lateinit var cbNote11P : CheckBox
    private lateinit var cbNote11eP : CheckBox
    private lateinit var cbNote11E : CheckBox
    private lateinit var cbNote114g : CheckBox
    private lateinit var tvTotal : TextView
    private lateinit var btnTotal : Button
    private var price  = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.actionbar)
        cbK50 = findViewById<CheckBox>(R.id.cbK50)
         cbNote11P = findViewById<CheckBox>(R.id.cbNote11P)
         cbNote11eP = findViewById<CheckBox>(R.id.cbNote11eP)
         cbNote11E = findViewById<CheckBox>(R.id.cbNote11E)
         cbNote114g = findViewById<CheckBox>(R.id.cbNote114g)
        val tgbDis = findViewById<ToggleButton>(R.id.tgbDis)
        //val tvDis = findViewById<TextView>(R.id.tvDis)
        tvTotal = findViewById<TextView>(R.id.tvTotal)
        btnTotal = findViewById<Button>(R.id.btnTotal)
        btnTotal.setOnClickListener {
            price = 0
            addingCheckBox(cbK50)
            addingCheckBox(cbNote11P)
            addingCheckBox(cbNote11eP)
            addingCheckBox(cbNote11E)
            addingCheckBox(cbNote114g)
            if(tgbDis.isChecked) tvTotal.text = (price-(price*10/100)).toString() else tvTotal.text = price.toString()

        }
        //tvDis.text = price.toString()
        //btnTotal.setOnClickListener(this)

        cbK50.setOnClickListener(this)
        cbNote11P.setOnClickListener(this)
        cbNote11eP.setOnClickListener(this)
        cbNote11E.setOnClickListener(this)
        cbNote114g.setOnClickListener(this)
    }

    private fun addingCheckBox(cb : CheckBox ) {
        if (cb.isChecked) {
            val list : List<String> = cb.text.toString().split(" ")
            price += list.last().toInt()
            Log.i("price","$price")
         }
    }

    override fun onClick(v: View?) {
        val toastLibrary = ToastLibrary()
        when(v?.id) {
            R.id.cbK50 -> {
                toastLibrary.bigToast(this@Cart,"K50")
            }
            R.id.cbNote11P -> {

                toastLibrary.bigToast(this@Cart,"Note 11 pro")
            }
            R.id.cbNote11eP -> {
                toastLibrary.bigToast(this@Cart,"Note 11e pro")
            }
            R.id.cbNote11E -> {

                toastLibrary.bigToast(this@Cart,"Note11E")
            }
            R.id.cbNote114g -> {

                toastLibrary.bigToast(this@Cart,"Note11 4g")
            }
        }
    }



}