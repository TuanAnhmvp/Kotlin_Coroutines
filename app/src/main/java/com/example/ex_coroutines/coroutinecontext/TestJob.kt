package com.example.ex_coroutines.coroutinecontext

import kotlinx.coroutines.*

//fun main(){
//    val job1: Job = GlobalScope.launch {
//        delay(2000)
//        println("Hello Kotlin")
//    }
//
// doi job dau tien thuc hien xog moi thuc hien cv job2
//    val job2: Job = GlobalScope.launch {
//        job1.join()
//        delay(1000)
//        println("I'm Coroutines")
//    }
//
//    Thread.sleep(7000)
//}

//fun main(){
//    runBlocking {
//        val job = launch(Dispatchers.Default) {
//            repeat(1000){
//                delay(500)
//                println("I'm sleeping $it...")
//            }
//        }
//
//        delay(4000)
//// dong coroutines
//        job.cancel()
//        println("Cancled croutines")
//    }
//}

/*
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()

    //coroutines
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // computation loop, just wastes CPU
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }


    delay(1600) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}
 */

/*
fun main(){
  runBlocking {
      val job = launch {
          try {
              repeat(1000){
                  delay(100)
                  println("Hello Croutines")
              }
          }finally {
              println("Print from finally")
          }
      }
      // check xem coroutines con song hay k
      delay(3000)
      println("I want stap coroutines")
      job.cancel()

  }
}

 */

fun main(){
    runBlocking {
        val job = launch {
            try {
                repeat(1000){
                    delay(100)
                    println("Hello Croutines")
                }
            }finally {
                println("Print from finally")
                // withcontext noncancle khien ham nay bat tu du da cancle coroutines
                withContext(NonCancellable){
                    repeat(10){
                        delay(100)
                        println("Print from Noncancellable")
                    }

                }
            }
        }
        // check xem coroutines con song hay k
        delay(3000)
        println("I want stap coroutines")
        job.cancel()

    }
}