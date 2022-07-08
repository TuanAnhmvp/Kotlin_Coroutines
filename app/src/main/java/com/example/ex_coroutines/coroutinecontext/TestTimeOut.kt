package com.example.ex_coroutines.coroutinecontext

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
//        // withTimeout tg quy dinh
//        withTimeout(1800){
//            repeat(3){
//                println("I'm sleeping $it")
//                delay(500)
//            }
//        }

        val result = withTimeoutOrNull(1800) {
            repeat(3) {
                println("I'm sleeping $it")
                delay(500)
            }
            "Done"
        }

        // trong tg quy dinh tra ve done, fell return null
        println("Result = $result")
    }
}