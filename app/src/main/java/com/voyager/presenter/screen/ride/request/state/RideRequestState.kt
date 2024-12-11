package com.voyager.presenter.screen.ride.request.state

import com.voyager.core.enums.FeedBackType
import com.voyager.data.remote.model.ride.request.estimate.RideEstimateRequestBody
import com.voyager.domain.model.ride.estimate.Option
import com.voyager.domain.model.ride.estimate.RideEstimate
import com.voyager.domain.model.ride.error.RideEstimateError


data class RideRequestState(
    val isLoading: Boolean = false,
    val requestBody: RideEstimateRequestBody = RideEstimateRequestBody(),
    val errorResponseBody: String = "",
    val error : RideEstimateError? = null,
    val rideEstimate: RideEstimate? = null,
    val id: String = "",
    val origin: String = "",
    val destination: String = "",
    val options: List<Option>? = null,
    val hasFeedBack: Boolean = false,
    val feedBack: Pair<FeedBackType, String>? = null
)