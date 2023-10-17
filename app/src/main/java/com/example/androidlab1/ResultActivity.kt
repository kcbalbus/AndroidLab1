package com.example.androidlab1

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultHistory: ResultHistory = ResultHistory.getInstance()
        val result = resultHistory.getLastResult()


        val textBMI: EditText = this.findViewById(R.id.editTextResultNum)
        textBMI.setText(result.BMI.toString())
        val textDescription: EditText = this.findViewById(R.id.editTextResultTxt)
        textDescription.setText(result.description.toString())

    }
}