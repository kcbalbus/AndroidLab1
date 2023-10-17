package com.example.androidlab1

import android.util.Log
import kotlin.math.round

class Result(val height: Double, val weight: Double) {

    val BMI = round(weight/((height/100)*(height/100))*100)/100
    var description = ""
    init{
        if (BMI<18.5){
            description = "Underweight"
        } else if (BMI<25.0){
            description = "Healthy weight"
        } else if (BMI<30.0){
            description = "Overweight"
        } else {
            description = "Obesity"
        }
    }
}