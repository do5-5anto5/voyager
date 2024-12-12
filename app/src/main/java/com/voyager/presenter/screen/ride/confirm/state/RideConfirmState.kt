package com.voyager.presenter.screen.ride.confirm.state

import com.voyager.core.enums.FeedBackType
import com.voyager.data.remote.model.ride.request.confirm.RideConfirmRequestBody
import com.voyager.domain.model.ride.error.RideEstimateError
import com.voyager.domain.model.ride.estimate.Option
import com.voyager.domain.model.ride.estimate.RideEstimate


data class RideConfirmState(
    val isLoading: Boolean = false,
    val options: List<Option> = emptyList(),
    val requestBody: RideConfirmRequestBody = RideConfirmRequestBody(),
    val errorResponseBody: String = "",
    val error : RideEstimateError? = null,
    val rideEstimate: RideEstimate? = null,
    val id: String = "",
    val origin: String = "",
    val destination: String = "",
    val hasFeedBack: Boolean = false,
    val feedBack: Pair<FeedBackType, String>? = null
)