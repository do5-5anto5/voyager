package com.voyager.presenter.screen.ride_request.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voyager.domain.usecase.ride.GetRideEstimateUseCase
import com.voyager.presenter.screen.ride_request.action.RideRequestAction
import com.voyager.presenter.screen.ride_request.state.RideRequestState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RideRequestViewModel(
    private val getRideEstimateUseCase: GetRideEstimateUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(RideRequestState())
    val state = _state.asStateFlow()

    fun submitAction(action: RideRequestAction) {

    }

    fun getRideEstimate(
        customerId: String?,
        origin: String?,
        destination: String?
    ) {
        try {
            viewModelScope.launch {
                getRideEstimateUseCase.invoke(customerId, origin, destination)
            }

        } catch (exception: HttpException) {
            exception.printStackTrace()
            exception.message
        }
    }
}