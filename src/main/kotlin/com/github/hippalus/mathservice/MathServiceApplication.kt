package com.github.hippalus.mathservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MathServiceApplication

fun main(args: Array<String>) {
    runApplication<MathServiceApplication>(*args)
}
