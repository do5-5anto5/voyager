package com.voyager.domain.repository

import com.voyager.data.remote.model.request_body.RideEstimateRequestBody
import com.voyager.data.remote.model.ride_estimate_response.RideEstimateResponse

interface RideRepository {

    suspend fun getRideEstimate(
        body: RideEstimateRequestBody
    ) : RideEstimateResponse

}