package com.voyager.domain.repository

import com.voyager.data.remote.model.ride.request.confirm.RideConfirmRequestBody
import com.voyager.data.remote.model.ride.request.estimate.RideEstimateRequestBody
import com.voyager.data.remote.model.ride.response.confirm.RideConfirmResponse
import com.voyager.data.remote.model.ride.response.estimate.RideEstimateResponse

interface RideRepository {

    suspend fun getRideEstimate(
        body: RideEstimateRequestBody
    ) : RideEstimateResponse

    suspend fun confirmRide(
        body: RideConfirmRequestBody
    ) : RideConfirmResponse

}