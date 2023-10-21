package com.example.androidlab1

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Stack

class ResultHistory {

    private var resultList: ArrayList<Result> = ArrayList()

    fun addResult(result: Result){
        resultList.add(result)
    }

    fun getLastResult(): Result{
        return resultList.get(resultList.size-1)
    }

    fun getHistory(): ArrayList<Result> {
        val history: ArrayList<Result> = ArrayList<Result>(resultList.reversed())
        return history
    }

    fun saveArrayListToSharedPreferences(context: Context) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(resultList)

        editor.putString("history", json)
        editor.apply()

    }


    fun loadArrayListFromSharedPreferences(context: Context) {
        if(resultList.isEmpty())
        {

            val sharedPreferences: SharedPreferences = context.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
            val gson = Gson()
            val json = sharedPreferences.getString("history", null)


            if (json != null) {
                val loadedData: ArrayList<Result> = gson.fromJson(json, object : TypeToken<ArrayList<Result>>() {}.type)
                resultList = loadedData
            }

        }

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