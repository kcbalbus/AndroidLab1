package com.example.androidlab1

import android.content.Intent
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
        val textDescription: TextView = this.findViewById(R.id.textViewResultTxt)
        textDescription.setText(result.description.toString())
        val buttonCalculate: Button = this.findViewById(R.id.buttonReturn)
        buttonCalculate.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}