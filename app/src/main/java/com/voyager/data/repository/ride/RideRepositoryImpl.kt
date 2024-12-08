package com.voyager.data.repository.ride

import com.voyager.data.api_service.ApiService
import com.voyager.data.model.ride_response.estimate.RideEstimateResponse
import com.voyager.domain.repository.ride.RideRepository

class RideRepositoryImpl(
    private val apiService: ApiService
) : RideRepository {

    override suspend fun getRideEstimate(
        customerId: String?,
        origin: String?,
        destination: String?
    ): RideEstimateResponse {
        return apiService.getRideEstimate(
            customerId,
            origin,
            destination
        )
    }

}