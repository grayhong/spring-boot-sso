package com.grayground.server

import com.grayground.server.config.JpaConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.system.exitProcess

@SpringBootApplication
class SsoServerApplication

fun main(args: Array<String>) {
    try {
        SpringApplication(SsoServerApplication::class.java).run(*args)
    } catch (e: Exception) {
        exitProcess(1)
    }
}