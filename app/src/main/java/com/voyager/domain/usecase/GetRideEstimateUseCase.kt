package com.voyager.domain.usecase

import com.voyager.data.mapper.toDomain
import com.voyager.data.remote.model.ride.request.estimate.RideEstimateRequestBody
import com.voyager.domain.repository.RideRepository

class GetRideEstimateUseCase(
    private val repository: RideRepository
) {

    suspend operator fun invoke(body: RideEstimateRequestBody) = repository.getRideEstimate(body).toDomain()

}