package com.grayground.server.controller

import com.grayground.server.entity.EmailUser
import com.grayground.server.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.support.ContextExposingHttpServletRequest
import java.util.*
import javax.servlet.http.HttpServletRequest

@RestController
class SsoServerController {

    @Autowired
    lateinit private var userRepository: UserRepository

    @Autowired
    lateinit private var passwordEncoder: BCryptPasswordEncoder

    @Autowired
    lateinit private var authenticationManager: AuthenticationManager

    @GetMapping("/hello")
    fun hello() : String {
        return "Hello"
    }

    @Secured("ROLE_BASIC")
    @GetMapping("/secured/hello")
    fun helloSecured() : String {
        return "Hello"
    }

    @PostMapping("/signup")
    fun signUp(
        @RequestParam username: String,
        @RequestParam password: String,
        @RequestParam email: String
    ) : String {
        userRepository.save(EmailUser().apply{
            this.username = username
            this.email = email
            this.password = passwordEncoder.encode(password)
            this.dateCreated = Date()
        })
        return "username: $username signed"
    }

    @PostMapping("/login")
    fun login(
            httpServletRequest: HttpServletRequest,
            @RequestParam username: String,
            @RequestParam password: String
    ) : String {
        try {
            val authentication = authenticationManager.authenticate(
                    UsernamePasswordAuthenticationToken(username, password)
            )
            if (authentication != null){
                val sc = SecurityContextHolder.getContext().apply {
                    this.authentication = authentication
                }
                httpServletRequest.getSession(true).apply {
                    this.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc)
                }
                return "Hello $username!"
            }
            else
                return "Failed to login with username: $username"
        } catch (e: Exception) {
            return "Failed to login with username: $username"
        }
    }
}