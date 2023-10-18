package com.example.androidlab1

import android.util.Log
import java.util.Stack

class ResultHistory {

    private var resultList: ArrayList<Result> = ArrayList()

    fun addResult(result: Result){
        resultList.add(result)
    }

    fun getLastResult(): Result{
        return resultList.get(resultList.size-1)
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