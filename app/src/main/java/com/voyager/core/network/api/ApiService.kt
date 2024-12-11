package com.voyager.core.network.api

import com.voyager.data.remote.model.ride.request.confirm.RideConfirmRequestBody
import com.voyager.data.remote.model.ride.request.estimate.RideEstimateRequestBody
import com.voyager.data.remote.model.ride.response.confirm.RideConfirmResponse
import com.voyager.data.remote.model.ride.response.estimate.RideEstimateResponse
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface ApiService {

    @POST("ride/estimate")
    suspend fun getRideEstimate(
        @Body body: RideEstimateRequestBody,
    ): RideEstimateResponse

    @PATCH("ride/confirm")
    suspend fun confirmRide(
        @Body body: RideConfirmRequestBody
    ): RideConfirmResponse
}