package com.henry.kotlincoroutineexample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinCoroutineExampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinCoroutineExampleApplication::class.java, *args)
}