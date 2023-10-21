package com.example.androidlab1

import android.util.Log
import kotlinx.serialization.Serializable
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.round



data class Result(private val height: Double, private val weight: Double, private val metric: Boolean) {

    val timestamp: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
    val BMI: Double


    init{

        if (metric){
            BMI = round(weight/((height/100)*(height/100))*10)/10
        } else {
            BMI = round(weight/((height)*(height))*7030)/10
        }
    }
}