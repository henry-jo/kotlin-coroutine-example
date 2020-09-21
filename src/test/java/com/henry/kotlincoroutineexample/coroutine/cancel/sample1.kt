package com.henry.kotlincoroutineexample.coroutine.cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            // 여기서 delay가 빠지게 되면 1000번 루프를 모두 돌고 아래 로직이 실행된다.
            // delay안에 있는 isActive로 체크하면서 Exception을 던지기 때문이다.
            // isActive는 코루틴 내부에 cancel 로직이 있는지 확인한다.
            delay(500L)
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    println("main: Now I can quit.")
}
