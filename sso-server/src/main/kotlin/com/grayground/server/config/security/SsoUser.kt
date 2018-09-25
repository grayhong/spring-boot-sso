package com.grayground.server.config.security

import com.grayground.server.entity.EmailUser
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class SsoUser(
    private var emailUser: EmailUser
) : UserDetails {
    override fun getAuthorities(): ArrayList<out GrantedAuthority> {
        return arrayListOf(SimpleGrantedAuthority("ROLE_BASIC"))
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return emailUser.username ?: ""
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return emailUser.password ?: ""
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}