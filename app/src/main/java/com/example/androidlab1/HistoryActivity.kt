package com.example.androidlab1

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)


        val resultHistory: ResultHistory = ResultHistory.getInstance()


        val recyclerview = findViewById<RecyclerView>(R.id.recyclerViewHistory)
        recyclerview.layoutManager = LinearLayoutManager(this)
        Log.d("00pi", "1")
        val adapter = HistoryHolder(resultHistory.getHistory())
        Log.d("00pi", "2")
        recyclerview.adapter = adapter

    }
}

