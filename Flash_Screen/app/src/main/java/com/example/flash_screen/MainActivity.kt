package com.example.flash_screen

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.ContactsContract
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.net.toUri
import java.io.File

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    private lateinit var rGroup: RadioGroup
    private lateinit var tvChoose: TextView
    private lateinit var btnGo: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rGroup = findViewById(R.id.rGroup)
        tvChoose = findViewById(R.id.tvChoose)
        btnGo = findViewById(R.id.btnGo)
        rGroup.setOnCheckedChangeListener(this)
    }

    private fun <T> intent(java: Class<T>) {
        val intent = Intent(this, java)
        startActivity(intent)
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.rbPhoneCall -> {
                intent(CallPhone::class.java)
            }
            R.id.rbSendPic -> {
                intent(SendPicture::class.java)
            }
            R.id.rbSendInternalPic -> {
                sendInternalPicture()
            }
            R.id.rbSendEmail -> {
                intent(SendEmail::class.java)
            }
            R.id.rbLearn -> {
                intent(PlayVideo::class.java)
            }
        }
    }
//    private fun sendInternalPicture() {
//        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
//        val pathArray = path.list()
//        val arrayList = ArrayList<Uri>()
//        var uri : Uri
//        for (picture in pathArray!!) {
//            uri = "file://${pathArray}/$picture".toUri()
//            arrayList.add(uri)
//        }
//        val intent = Intent(Intent.ACTION_SEND)
//        intent.putExtra(Intent.EXTRA_STREAM,arrayList)
//        intent.type = "image/*"
//        startActivity(intent)
//    }

    private fun sendInternalPicture() {
        val f = Environment
            .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val list: Array<File> = arrayOf(f)
        val arrayList: ArrayList<Uri> = ArrayList()
        var uri : Uri
        for (picture in list) {
            uri = "file://${list}/$picture".toUri()
            arrayList.add(uri)
        }
        val intent = Intent(Intent.ACTION_SEND_MULTIPLE)
        intent.putExtra(Intent.EXTRA_STREAM,arrayList)
        intent.type = "image/*"
        startActivity(intent)
    }
}