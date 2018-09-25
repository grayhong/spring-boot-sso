package com.grayground.server.config.security

import com.grayground.server.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetailsService

class EmailLoginUserDetailsServiceAdapter (
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): SsoUser {
        val user = userRepository.findByUsername(username)
        return SsoUser(user)
    }
}