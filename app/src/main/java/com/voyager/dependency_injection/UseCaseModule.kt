package com.voyager.dependency_injection

import com.voyager.domain.usecase.GetRideEstimateUseCase
import com.voyager.domain.usecase.RideConfirmUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { GetRideEstimateUseCase(repository = get()) }

    factory { RideConfirmUseCase(repository = get()) }

}