package com.voyager.presenter.screen.ride_request.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voyager.data.remote.model.request_body.RideEstimateRequestBody
import com.voyager.domain.usecase.GetRideEstimateUseCase
import com.voyager.presenter.screen.ride_request.action.RideRequestAction
import com.voyager.presenter.screen.ride_request.state.RideRequestState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RideRequestViewModel(
    private val useCase: GetRideEstimateUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(RideRequestState())
    val state = _state.asStateFlow()

    fun submitAction(action: RideRequestAction) {
        when (action) {
            is RideRequestAction.GetRideEstimate -> {
                getRideEstimate(action.body)
            }
        }
    }

    fun getRideEstimate(body: RideEstimateRequestBody) {
        viewModelScope.launch{
            useCase(body)
        }
    }

}