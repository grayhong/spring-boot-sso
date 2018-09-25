package com.grayground.client.controller

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient

// connect session for each request using spring-session
@RestController
class SsoClientController(
    private val webClientBuilder: WebClient.Builder
) {

    data class LoginInfo ( var id: String, var password: String )

    private val webClient: WebClient

    init {
        webClient = webClientBuilder.baseUrl(SPARCS_SSO_URL).build()
    }

    // redirect to SSO server
    @GetMapping("/login")
    fun login() {
        webClient.post()
    }

    // automatically redirected from SSO server
    @GetMapping("/login/callback")
    fun loginCallback() {
        webClient.post()
    }

    // logout, remove sso token in session
    @GetMapping("/logout")
    fun logout() {

    }


    companion object {
        const val SPARCS_SSO_URL: String = "https://sparcssso.kaist.ac.kr"
    }
}