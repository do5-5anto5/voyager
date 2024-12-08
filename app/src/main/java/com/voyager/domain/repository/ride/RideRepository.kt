package com.voyager.domain.repository.ride

import com.voyager.data.model.ride_response.estimate.RideEstimateResponse

interface RideRepository {

    suspend fun getRideEstimate(
        customerId: String?,
        origin: String?,
        destination: String?
    ): RideEstimateResponse

}