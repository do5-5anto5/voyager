package com.voyager.data.remote.repository

import com.voyager.core.network.api.ApiService
import com.voyager.data.remote.model.request_body.RideEstimateRequestBody
import com.voyager.data.remote.model.ride_estimate_response.RideEstimateResponse
import com.voyager.domain.repository.RideRepository

class RideRepositoryImpl(
    private val apiService: ApiService
): RideRepository {
    override suspend fun getRideEstimate(body: RideEstimateRequestBody): RideEstimateResponse {
        return apiService.getRideEstimate(
            body
        )
    }
}