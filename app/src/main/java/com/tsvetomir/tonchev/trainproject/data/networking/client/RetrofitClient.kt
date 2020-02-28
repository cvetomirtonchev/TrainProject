package com.tsvetomir.tonchev.trainproject.data.networking.client

import com.tsvetomir.tonchev.trainproject.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

/**
 * Created by Tsvetomir.Tonchev on 2/25/2020.
 */

object RetrofitClient {
    private var mOkHttpClient: OkHttpClient.Builder = OkHttpClientFactory.createHttpClient()

    private val mBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.irishrail.ie/realtime/realtime.asmx/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(mOkHttpClient.build())
    }

    private var mRetrofit: Retrofit = mBuilder.build()

    fun <T> createService(service: Class<T>): T {
        return mRetrofit.create(service)
    }
}