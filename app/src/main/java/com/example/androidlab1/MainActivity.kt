package com.example.androidlab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.androidlab1.Result

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var result:Result

        val resultHistory: ResultHistory = ResultHistory.getInstance()

        val textInWeight: EditText = this.findViewById(R.id.editTextWeight)
        val textInHeight: EditText = this.findViewById(R.id.editTextHeight)
        val textOutResult: TextView = this.findViewById(R.id.textViewResult)
        val buttonCalculate: Button = this.findViewById(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener{
            result = Result(textInHeight.text.toString().toDouble(), textInWeight.text.toString().toDouble())
            resultHistory.addResult(result)
            textOutResult.setText(result.BMI.toString())
        }

        textOutResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }

    }


}