package com.voyager.presenter.screen.ride_request.action

sealed class RideRequestAction {
    data object GetRideEstimate : RideRequestAction()
    data object ResetErrorState : RideRequestAction()
    data class ChangeOrigin(val address: String) : RideRequestAction()
    data class ChangeDestination(val address: String) : RideRequestAction()
    data class ChangeName(val value: String) : RideRequestAction()
}