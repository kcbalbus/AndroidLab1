package com.example.androidlab1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultHistory: ResultHistory = ResultHistory.getInstance()
        val result = resultHistory.getLastResult()

        val textBMI: TextView = this.findViewById(R.id.textViewResultNum)
        textBMI.setText(result.BMI.toString())
        val textText: TextView = this.findViewById(R.id.textViewResultTxt)
        textText.setText(getBMITxt(result.BMI))
        val textDesc: TextView = this.findViewById(R.id.textViewResultDesc)
        textDesc.setText(getBMIDesc(result.BMI))

        if (result.BMI<18.5 || result.BMI>25){
            textBMI.setTextColor(Color.RED)
        } else{
            textBMI.setTextColor(Color.GREEN)
        }

    }


    fun getBMITxt(bmi: Double): String{
        if (bmi<18.5){
            return "Underweight"
        } else if (bmi<25.0){
            return "Healthy weight"
        } else if (bmi<30.0){
            return "Overweight"
        } else {
            return "Obesity"
        }
    }

    fun getBMIDesc(bmi: Double): String{
        if (bmi<18.5){
            return "Being underweight may suggest insufficient body fat and potential health risks. It's important to consult with a healthcare professional for a personalized assessment and guidance."
        } else if (bmi<25.0){
            return "Congratulations! Your BMI suggests that your weight is in a healthy range for your height. Keep up the good work with a balanced diet and regular physical activity to maintain your well-being."
        } else if (bmi<30.0){
            return "Your BMI suggests that you may be carrying excess weight, which can increase the risk of health issues. Consider adopting a healthier lifestyle, including improved nutrition and increased physical activity."
        } else {
            return "Obesity is associated with various health risks. It's crucial to consult a healthcare professional for a comprehensive assessment and develop a plan for weight management and improved health."
        }
    }
}