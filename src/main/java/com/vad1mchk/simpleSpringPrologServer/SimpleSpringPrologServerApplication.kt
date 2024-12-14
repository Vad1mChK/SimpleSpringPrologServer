package com.vad1mchk.simpleSpringPrologServer


import com.vad1mchk.simpleSpringPrologServer.engine.PrologTuprologEngine
import com.vad1mchk.simpleSpringPrologServer.engine.PrologEngine
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class SimpleSpringPrologServerApplication {
   @Bean
   open fun prologEngine(): PrologEngine = PrologTuprologEngine()
}

fun main(args: Array<String>) {
    runApplication<SimpleSpringPrologServerApplication>(*args)
}