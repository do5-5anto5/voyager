package com.voyager.domain.usecase

import com.voyager.data.model.mapper.toDomain
import com.voyager.data.remote.model.request_body.RideEstimateRequestBody
import com.voyager.domain.repository.RideRepository

class GetRideEstimateUseCase(
    private val repository: RideRepository
) {

    suspend operator fun invoke(body: RideEstimateRequestBody) = repository.getRideEstimate(body).toDomain()

}