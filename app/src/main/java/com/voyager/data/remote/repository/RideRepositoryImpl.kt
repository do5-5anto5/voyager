package com.voyager.data.remote.repository

import com.voyager.core.network.api.ApiService
import com.voyager.data.remote.model.ride.request.confirm.RideConfirmRequestBody
import com.voyager.data.remote.model.ride.request.estimate.RideEstimateRequestBody
import com.voyager.data.remote.model.ride.response.confirm.RideConfirmResponse
import com.voyager.data.remote.model.ride.response.estimate.RideEstimateResponse
import com.voyager.domain.repository.RideRepository

class RideRepositoryImpl(
    private val apiService: ApiService
): RideRepository {
    override suspend fun getRideEstimate(body: RideEstimateRequestBody): RideEstimateResponse {
        return apiService.getRideEstimate(
            body
        )
    }

    override suspend fun confirmRide(body: RideConfirmRequestBody): RideConfirmResponse {
        return apiService.confirmRide(
            body
        )
    }
}