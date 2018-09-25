package com.grayground.client.service.impl

import com.grayground.client.service.SsoClientService
import org.springframework.stereotype.Component

@Component
class SsoClientServiceImpl : SsoClientService{
    override fun getLoginParams() {

    }

    override fun getUserInfo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLogoutUrl() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun signPayLoad(
        vararg payload: String,
        appendTimestamp: Boolean = true
    ) {

    }

    companion object {
        const val SSO_CLIENT_ID = "home"
        const val SSO_SECRET_KEY = "87082063e9559700e2a0"
        const val FIXED_TOKEN = "abcde12345abcde12345"
    }
}