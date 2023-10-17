package com.example.androidlab1

import android.util.Log
import java.util.Stack

class ResultHistory {

    private var resultList: Stack<Result> = Stack()

    fun addResult(height: Double, weight: Double){
        resultList.add(Result(height, weight))
    }

    fun getLastResult(): Result{
        return resultList.peek()
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