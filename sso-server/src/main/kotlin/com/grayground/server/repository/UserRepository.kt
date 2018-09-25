package com.grayground.server.repository

import com.grayground.server.entity.EmailUser
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<EmailUser, Long> {
    fun findByUsername(username: String) : EmailUser
}