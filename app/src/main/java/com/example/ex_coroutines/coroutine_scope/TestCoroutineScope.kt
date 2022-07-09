package com.example.ex_coroutines.coroutine_scope

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main() {
    /*
    // cac cach launch coroutines
    runBlocking {
        launch {

        }
        async {

        }
    }

    CoroutineScope(Dispatchers.Default).launch {
        launch {

        }

        async {

        }
    }

    // cac ham extent lai coroutineScope len launch dc
    GlobalScope.launch {

    }

    MyCoroutineScope().launch {

    }
     */
    /*
    runBlocking {
        val job1 = launch {
            launch {
                delay(100)
                println("coroutine 1: Hello ")
                delay(1000)
                println("coroutin 1: Goodbyte")
            }

            launch {
                delay(100)
                println("coroutine 2: Hello ")
                delay(1000)
                println("coroutin 2: Goodbyte")
            }

            // job1.cancel nhung trong globalscope k cancle
            GlobalScope.launch {
                delay(100)
                println("coroutine 3: Hello ")
                delay(1000)
                println("coroutin 3: Goodbyte")
            }
        }
        delay(500)
        job1.cancel()
        delay(3000)
    }

     */

    runBlocking {
        val job = launch {
            repeat(3){
                launch {
                    delay(100)
                    println("Coroutine $it")
                }

            }
            // thuc hien truoc
            println("Print from parent")
        }
        job.join()
        delay(1000)

    }

}


// custom 1 croutinescope
class MyCoroutineScope() : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

}
