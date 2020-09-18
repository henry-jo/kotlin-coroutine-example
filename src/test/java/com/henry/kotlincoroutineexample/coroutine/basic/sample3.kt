package com.henry.kotlincoroutineexample.coroutine.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { // 별다른 명시없이 launch를 한다면, 바깥에 있는 스코프와 동일한 스코프가 생성된다.
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}