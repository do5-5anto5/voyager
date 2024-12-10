package com.voyager.presenter.screen.ride_request.state

import com.voyager.data.remote.model.request_body.RideEstimateRequestBody


data class RideRequestState(
    val isLoading: Boolean = true,
    val requestBody: RideEstimateRequestBody = RideEstimateRequestBody(),
    val id: String = "",
    val origin: String = "",
    val destination: String = ""
)