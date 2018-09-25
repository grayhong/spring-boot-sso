package com.grayground.server.config

import com.grayground.server.repository.UserRepository
import com.grayground.server.security.EmailLoginUserDetailsServiceAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class SecurityConfig {

    @Bean
    fun passwordEncoder() : BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun emailLoginUserDetailsService(
            userRepository: UserRepository
    ) : EmailLoginUserDetailsServiceAdapter {
        return EmailLoginUserDetailsServiceAdapter(userRepository)
    }

    @Bean
    fun daoAuthenticationProvider(
            emailLoginUserDetailsService: EmailLoginUserDetailsServiceAdapter,
            passwordEncoder: BCryptPasswordEncoder
    ) : DaoAuthenticationProvider {
        return DaoAuthenticationProvider().apply {
            setUserDetailsService(emailLoginUserDetailsService)
            setPasswordEncoder(passwordEncoder)
        }
    }

}