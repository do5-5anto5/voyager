package com.voyager.dependency_injection

import com.voyager.core.network.api.ApiProvider
import com.voyager.data.api_service.ApiService
import org.koin.dsl.module

val networkModule = module {

    single<ApiProvider> { ApiProvider() }

    factory<ApiService> { get<ApiProvider>().createService(ApiService::class.java) }

}