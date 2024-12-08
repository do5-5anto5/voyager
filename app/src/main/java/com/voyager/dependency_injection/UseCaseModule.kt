package com.voyager.dependency_injection

import com.voyager.domain.usecase.GetRideEstimateUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetRideEstimateUseCase(repository = get()) }
}