package com.example.framelayout

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*

class CustomLibs(context: Context) {
    private val sp : SoundPool = SoundPool(1,AudioManager
        .STREAM_MUSIC,0)
    val clipy = sp.load(context,R.raw.sound,1)
    fun playSound() {
        sp.play(clipy,1f,1f,0,0,1f)
    }
    fun pauseSound() {
        sp.autoPause()
    }
    @SuppressLint("SimpleDateFormat")
    fun getDateTime(): String {
        val dateTime =SimpleDateFormat("dd/MM/yy hh:mm:ss")
        return dateTime.format(Calendar.getInstance().time)
    }

}