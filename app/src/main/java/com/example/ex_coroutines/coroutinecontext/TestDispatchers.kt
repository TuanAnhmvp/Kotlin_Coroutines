package com.example.ex_coroutines.coroutinecontext

import android.util.Log
import com.example.ex_coroutines.MainActivity


import kotlinx.coroutines.*

object TestDispatchers{
    fun runMyFirstCoroutines(){
        GlobalScope.launch(Dispatchers.Default) {
            Log.d(MainActivity::class.java.simpleName, "Dispatchers default on ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.IO) {
            Log.d(MainActivity::class.java.simpleName, "Dispatchers IO on ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Main) {
            Log.d(MainActivity::class.java.simpleName, "Dispatchers Main on ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d(MainActivity::class.java.simpleName, "before Dispatchers Unconfined on ${Thread.currentThread().name}")
            delay(1000)
            // sau khi bi chay lau dai se chay tren mot thead khac
            Log.d(MainActivity::class.java.simpleName, "Dispatchers Unconfined on ${Thread.currentThread().name}")
        }

        GlobalScope.launch(newSingleThreadContext("My thread")) {
            Log.d(MainActivity::class.java.simpleName, "run on ${Thread.currentThread().name}")
        }

    }
}