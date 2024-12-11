package com.voyager.dependency_injection

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.voyager.core.constants.url.BaseUrl.BASE_URL
import com.voyager.core.network.api.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import kotlin.jvm.java

val apiServiceModule = module {
    single {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json{ ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()

        retrofit.create(ApiService::class.java)
    }
}