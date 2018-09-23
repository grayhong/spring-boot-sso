package com.grayground.client

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.system.exitProcess

@SpringBootApplication
class SsoClientApplication

fun main(args: Array<String>) {
    try {
        SpringApplication(SsoClientApplication::class.java).run(*args)
        exitProcess(0)
    } catch (e: Exception) {
        exitProcess(1)
    }
}