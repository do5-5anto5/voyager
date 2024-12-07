package com.voyager.presenter.screen.ride_request.viewModel


import androidx.lifecycle.ViewModel
import com.voyager.presenter.screen.ride_request.action.RideRequestAction
import com.voyager.presenter.screen.ride_request.state.RideRequestState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RideRequestViewModel : ViewModel() {

    private val _state = MutableStateFlow(RideRequestState())
    val state = _state.asStateFlow()

    fun submitAction(action: RideRequestAction) {

    }
}