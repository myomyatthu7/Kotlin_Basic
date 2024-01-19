package com.example.oopdemo

import android.util.Log

class Driver(name : String) {
    private var driverName : String
    private val car = Car()
    init {
        car.start()
        car.maxSpeed = 150
        Log.i("activity","Max Speed ${car.maxSpeed}")
        driverName = name
    }
    fun showName() {
        Log.i("Activity","Driver name is $driverName")

    }
}