package com.example.kotlinwithspringdatasample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinWithSpringDataSampleApplication

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<KotlinWithSpringDataSampleApplication>(*args)
}
