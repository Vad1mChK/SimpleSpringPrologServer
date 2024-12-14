package com.vad1mchk.simpleSpringPrologServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SimpleSpringPrologServerApplication

fun main(args: Array<String>) {
    runApplication<SimpleSpringPrologServerApplication>(*args)
}