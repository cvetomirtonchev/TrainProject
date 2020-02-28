package com.tsvetomir.tonchev.trainproject.data.networking.client

import okhttp3.CookieJar
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.CookieHandler
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit


/**
 * Created by Tsvetomir.Tonchev on 2/25/2020.
 */
object OkHttpClientFactory {
    fun createHttpClient(): OkHttpClient.Builder {
        val cookieManager = CookieManager(null, CookiePolicy.ACCEPT_ALL)
        CookieHandler.setDefault(cookieManager)
        return OkHttpClient.Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .retryOnConnectionFailure(true)
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
    }

}