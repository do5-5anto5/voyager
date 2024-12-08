package com.voyager.core.network.api

import com.voyager.data.remote.model.request_body.RideEstimateRequestBody
import com.voyager.data.remote.model.ride_estimate_response.RideEstimateResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("ride/estimate")
    suspend fun getRideEstimate(
        @Body body: RideEstimateRequestBody,
    ): RideEstimateResponse
}