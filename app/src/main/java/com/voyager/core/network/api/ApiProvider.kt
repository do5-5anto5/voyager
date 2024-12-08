package com.voyager.core.network.api

import com.voyager.core.constants.url.BaseUrl.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class ApiProvider {

    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .client(client)
        .build()

    fun <API> createService(apiClass: Class<API>): API =
        retrofit.create(apiClass)

}