package com.example.ex_coroutines.async_await

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

fun main(){
    runBlocking {
        val time = measureTimeMillis {
            val a: Deferred<Int> = async { doSomeThingFunny1() }
            val b: Deferred<Int> = async { doSomeThingFunny2() }
            println(a.await()+b.await())
        }
        println("Time = $time")

    }

}
suspend fun doSomeThingFunny1():Int{
    delay(1000)
    return 10
}

suspend fun doSomeThingFunny2():Int{
    delay(1000)
    return 20
}