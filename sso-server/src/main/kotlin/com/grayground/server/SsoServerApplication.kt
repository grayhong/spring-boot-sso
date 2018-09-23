package com.grayground.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.system.exitProcess

@SpringBootApplication
class SsoServerApplication

fun main(args: Array<String>) {
    try {
        SpringApplication(SsoServerApplication::class.java).run(*args)
        exitProcess(0)
    } catch (e: Exception) {
        exitProcess(1)
    }
}