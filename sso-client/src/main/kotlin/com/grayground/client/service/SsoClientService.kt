package com.grayground.client.service

interface SsoClientService {

    fun getLoginParams()

    fun getUserInfo()

    fun getLogoutUrl()
}