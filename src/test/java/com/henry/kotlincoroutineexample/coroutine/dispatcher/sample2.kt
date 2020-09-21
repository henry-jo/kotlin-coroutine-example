package com.henry.kotlincoroutineexample.coroutine.dispatcher

import com.henry.kotlincoroutineexample.coroutine.suspend.doSomethingUsefulOne
import com.henry.kotlincoroutineexample.coroutine.suspend.doSomethingUsefulTwo
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// Add jvm option : -Dkotlinx.coroutines.debug

// 모두 main thread 위에서 작동하지만, coroutine scope이 다르다.
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async {
            println("one method : I'm working in thread ${Thread.currentThread().name}")
            doSomethingUsefulOne()
        }
        val two = async {
            println("two method : I'm working in thread ${Thread.currentThread().name}")
            doSomethingUsefulTwo()
        }
        println("The answer is ${one.await() + two.await()}")
    }
    println("runBlocking method : I'm working in thread ${Thread.currentThread().name}")
    println("Completed in $time ms")
}