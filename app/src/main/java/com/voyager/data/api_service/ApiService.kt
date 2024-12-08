package com.voyager.data.api_service

import com.voyager.data.model.ride_response.estimate.RideEstimateResponse
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("ride/estimate")
    suspend fun getRideEstimate(
        @Query("customer_id") customerId: String?,
        @Query("origin") origin: String?,
        @Query("destination") destination: String?
    ): RideEstimateResponse
}