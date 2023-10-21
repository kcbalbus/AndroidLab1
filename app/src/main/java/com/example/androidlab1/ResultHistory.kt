package com.example.androidlab1

import android.content.SharedPreferences
import android.util.Log
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Stack

class ResultHistory {

    private var resultList: ArrayList<Result> = ArrayList()

    fun addResult(result: Result){
        resultList.add(result)
        Log.d("missing res", resultList.toString())
    }

    fun getLastResult(): Result{
        return resultList.get(resultList.size-1)
    }

    fun getHistory(): ArrayList<Result> {
        val history: ArrayList<Result> = ArrayList<Result>(resultList.reversed())
        Log.d("missing res", history.toString())
        return history
    }

    fun saveHistory(){
        val json = Json.encodeToString(resultList)

        //val sharedPreferences: SharedPreferences =
    }

    fun loadHistory(){
        //resultList = Json.decodeFromString<ArrayList<Result>>()
    }

    companion object {
        @Volatile
        private var INSTANCE: ResultHistory? = null

        fun getInstance() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: ResultHistory().also {
                    INSTANCE = it
                }
            }
    }
}