package com.grayground.server.security

import com.grayground.server.repository.UserRepository
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class EmailLoginUserDetailsServiceAdapter (
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): SsoUser {
        val user = userRepository.findByUsername(username)
        return SsoUser(user)
    }
}