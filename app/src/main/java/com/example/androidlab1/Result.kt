package com.example.androidlab1

import android.util.Log
import kotlin.math.round

class Result(val height: Double, val weight: Double, val metric: Boolean) {

    val BMI: Double

    init{
        if (metric){
            BMI = round(weight/((height/100)*(height/100))*10)/10
        } else {
            BMI = round(weight/((height)*(height))*7030)/10
        }
    }
}