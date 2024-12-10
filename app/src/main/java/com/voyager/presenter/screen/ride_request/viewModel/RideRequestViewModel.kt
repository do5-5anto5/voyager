package com.voyager.presenter.screen.ride_request.viewModel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voyager.data.remote.model.request_body.RideEstimateRequestBody
import com.voyager.domain.usecase.GetRideEstimateUseCase
import com.voyager.presenter.screen.ride_request.action.RideRequestAction
import com.voyager.presenter.screen.ride_request.state.RideRequestState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RideRequestViewModel(
    private val useCase: GetRideEstimateUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(RideRequestState())
    val state = _state.asStateFlow()

    fun submitAction(action: RideRequestAction) {
        when (action) {
            is RideRequestAction.GetRideEstimate -> {
                getRideEstimate()
            }

            is RideRequestAction.ChangeDestination -> {
                changeDestination(action.address)
            }

            is RideRequestAction.ChangeOrigin -> {
                changeOrigin(action.address)
            }

            is RideRequestAction.ChangeName -> {
                onValueChange(action.value)
            }
        }
    }

    private fun onValueChange(value: String) {
        _state.update { currentState ->
            currentState.copy(
                id = value
            )
        }
    }

    private fun changeOrigin(address: String) {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    origin = address
                )
            }
        }
    }

    private fun changeDestination(address: String) {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    destination = address
                )
            }
        }
    }

    fun getRideEstimate() {
        try {
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        requestBody = RideEstimateRequestBody(
                            customerId = validateRequestBodyState(currentState.id),
                            origin = validateRequestBodyState(currentState.origin),
                            destination = validateRequestBodyState(currentState.destination)
                        )
                    )
                }

                Log.i("RequestBodyState", "${_state.value.requestBody}")

                useCase(_state.value.requestBody)
            }
        } catch (e: HttpException) {
            //TODO
        }
    }

    private fun validateRequestBodyState(value: String): String? {
        return if (value.isBlank() == true) {
            null
        } else {
            value
        }
    }

}