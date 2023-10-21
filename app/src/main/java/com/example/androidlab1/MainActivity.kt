package com.example.androidlab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toolbar
import com.example.androidlab1.Result

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var result:Result = Result(-1.0, -1.0, true)
        val resultHistory: ResultHistory = ResultHistory.getInstance()
        resultHistory.loadArrayListFromSharedPreferences(this)

        val toolbar: androidx.appcompat.widget.Toolbar = this.findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val textInWeight: EditText = this.findViewById(R.id.editTextWeight)
        val textInHeight: EditText = this.findViewById(R.id.editTextHeight)
        val textOutHeight: TextView = this.findViewById(R.id.textViewHeightMeasure)
        val textOutResult: TextView = this.findViewById(R.id.textViewResult)
        val buttonCalculate: Button = this.findViewById(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener{
            result = Result(textInHeight.text.toString().toDouble(), textInWeight.text.toString().toDouble(), textOutHeight.text.equals("cm"))
            resultHistory.addResult(result)
            textOutResult.setText(result.BMI.toString())
        }

        textOutResult.setOnClickListener {
            if(result.BMI>=0.0){
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            }
        }

    }

    override fun onPause() {
        super.onPause()
        val resultHistory: ResultHistory = ResultHistory.getInstance()
        resultHistory.saveArrayListToSharedPreferences(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.metric -> {
                val textOutHeight: TextView = this.findViewById(R.id.textViewHeightMeasure)
                val textOutWeight: TextView = this.findViewById(R.id.textViewWeightMeasure)


                if (textOutHeight.text.equals("cm")){
                    textOutHeight.setText("inch")
                    textOutWeight.setText("lb")
                } else {
                    textOutHeight.setText("cm")
                    textOutWeight.setText("kg")
                }

                return true

            }
            R.id.histroy -> {

                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)

                return true

            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


}