package com.voyager.presenter.screen.ride_request.state

import com.voyager.core.enums.FeedBackType
import com.voyager.data.remote.model.request_body.RideEstimateRequestBody
import com.voyager.domain.model.ride.RideEstimate
import com.voyager.domain.model.ride.error.RideEstimateError


data class RideRequestState(
    val isLoading: Boolean = true,
    val requestBody: RideEstimateRequestBody = RideEstimateRequestBody(),
    val errorResponseBody: String = "",
    val error : RideEstimateError? = null,
    val rideEstimate: RideEstimate? = null,
    val id: String = "",
    val origin: String = "",
    val destination: String = "",
    val hasFeedBack: Boolean = false,
    val feedBack: Pair<FeedBackType, String>? = null
)