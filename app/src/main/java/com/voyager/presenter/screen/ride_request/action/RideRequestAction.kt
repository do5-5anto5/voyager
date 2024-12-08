package com.voyager.presenter.screen.ride_request.action

import com.voyager.data.remote.model.request_body.RideEstimateRequestBody


sealed class RideRequestAction {
    data class GetRideEstimate(val body: RideEstimateRequestBody) : RideRequestAction()
}