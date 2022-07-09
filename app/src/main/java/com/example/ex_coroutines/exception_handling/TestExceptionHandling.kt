package com.example.ex_coroutines.exception_handling

import kotlinx.coroutines.*



suspend fun main(){

    /*
    runBlocking {
        // dung exhandler cho launch
        val handler = CoroutineExceptionHandler{_,exception ->
        println("Error here: ${exception.toString()}")
        }
        val job = GlobalScope.launch(handler + Dispatchers.Default) {
            println("Throw Exception from launch")
            throw NullPointerException()
        }
        // doi job hoan thanh roi moi thuc hien cv tiep
        job.join()
        val deferred = GlobalScope.async(handler) {
            println("Throw Exception from async")
            throw IndexOutOfBoundsException()
        }
        try {
            deferred.await()
        }catch (e:IndexOutOfBoundsException){
            println(e.toString())
        }

    }
     */

    /*
    runBlocking {
        val handle = CoroutineExceptionHandler{_, exception ->
            println("Exception: $exception")
        }

        val job = GlobalScope.launch(handle) {
            launch {
                println("Coroutines = 1")
                delay(300)
                throw IndexOutOfBoundsException("Croutine 1")
            }

            launch {
                println("Coroutines = 2")
                //coroutines chay truoc throw ra excepton truoc va ket thuc
                delay(200)
                throw NullPointerException("Croutine 2")
            }

            launch {
                println("Coroutines = 3")
                delay(400)
                throw ArithmeticException("Croutine 3")
            }

        }
        job.join()
    }
     */


    /*runBlocking {
        val superVisJob = SupervisorJob()
        with(CoroutineScope(coroutineContext + superVisJob)){
            val firstChild = launch {
                println("Print from First Child")
                throw NullPointerException()
            }

            val secondChild = launch {
                firstChild.join()
                println("Print from second Child.First Child is Active: ${firstChild.isActive}")
                try {
                    delay(1000)

                }finally {
                    println("second child cancelled")
                }
            }
            firstChild.join()
            println("Canvelling SuperVisorJob")
            superVisJob.cancel()
            secondChild.join()

        }

    }*/

}