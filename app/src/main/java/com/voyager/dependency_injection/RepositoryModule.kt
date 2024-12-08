package com.voyager.dependency_injection

import com.voyager.data.remote.repository.RideRepositoryImpl
import com.voyager.domain.repository.RideRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<RideRepository> { RideRepositoryImpl(apiService = get()) }
}