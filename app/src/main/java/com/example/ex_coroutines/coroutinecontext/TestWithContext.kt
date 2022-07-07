package com.example.ex_coroutines.coroutinecontext

import android.util.Log
import com.example.ex_coroutines.MainActivity
import kotlinx.coroutines.*

object TestWithContext {
    fun testMyFirstWithContextFunc(){
        newSingleThreadContext("Thread 1").use { context1->
            Log.d(MainActivity::class.java.simpleName, "Context 1 - Thread : ${Thread.currentThread().name}")
            newSingleThreadContext("Thread 2").use { context2->
                Log.d(MainActivity::class.java.simpleName, "Context 2 - Thread : ${Thread.currentThread().name}")

                runBlocking(context1){
                    Log.d(MainActivity::class.java.simpleName, "Working in Context 1 - Thread : ${Thread.currentThread().name}")
                    withContext(context2){
                        Log.d(MainActivity::class.java.simpleName, "Working in Context 2 - Thread : ${Thread.currentThread().name}")

                    }
                    Log.d(MainActivity::class.java.simpleName, "Back to Context1  - Thread : ${Thread.currentThread().name}")

                }
            }
        }
    }

    fun testMySecondWithContextFunc(){
        GlobalScope.launch(Dispatchers.IO) {
            // run long time task
            Log.d(MainActivity::class.java.simpleName,
            "Run long time task - Thread : ${Thread.currentThread().name}")
            delay(2000)

            withContext(Dispatchers.Main){
                // update UI here
                Log.d(MainActivity::class.java.simpleName,
                    "Update UI - Thread : ${Thread.currentThread().name}")
            }
        }
    }
}