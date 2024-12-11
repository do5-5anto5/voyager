package com.voyager.presenter.screen.ride_request.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.voyager.core.enums.FeedBackType
import com.voyager.data.remote.model.request_body.RideEstimateRequestBody
import com.voyager.data.remote.model.ride_estimate_response.RideEstimateErrorResponse
import com.voyager.domain.model.ride.error.RideEstimateError
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

            RideRequestAction.ResetErrorState -> {
                resetErrorState()
            }
        }
    }

    private fun resetErrorState() {
        _state.update { currentState ->
            currentState.copy(
                hasFeedBack = false,
                feedBack = null
            )
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
        viewModelScope.launch {
            try {
                startLoading()
                _state.update { currentState ->
                    currentState.copy(
                        requestBody = RideEstimateRequestBody(
                            customerId = validateRequestBodyState(currentState.id),
                            origin = validateRequestBodyState(currentState.origin),
                            destination = validateRequestBodyState(currentState.destination)
                        )
                    )
                }

                val rideEstimate = useCase(_state.value.requestBody)

                _state.update { currentState ->
                    currentState.copy(
                        rideEstimate = rideEstimate
                    )
                }
                stopLoading()

                if (
                    _state.value.rideEstimate?.options?.isEmpty() == true
                    && _state.value.isLoading == false
                ) {
                    _state.update { currentState ->
                        currentState.copy(
                            hasFeedBack = true,
                            feedBack = Pair(
                                FeedBackType.WARNING,
                                "Nenhum motorista disponível"
                            )
                        )
                    }
                }
            } catch (e: HttpException) {
                if (e.code() == 400) {
                    startLoading()
                    val errorBody = e.response()?.errorBody()?.string()
                    _state.update { currentState ->
                        currentState.copy(
                            errorResponseBody = errorBody ?: ""
                        )
                    }

                    val apiRideEstimateError = Gson().fromJson(
                        errorBody,
                        RideEstimateErrorResponse::class.java
                    )

                    _state.update { currentState ->
                        currentState.copy(
                            error = apiRideEstimateError?.let {
                                RideEstimateError(
                                    it.errorCode,
                                    it.errorDescription
                                )
                            })
                    }
                    stopLoading()

                    if (_state.value.isLoading == false && _state.value.error != null) {
                        _state.update { currentState ->
                            currentState.copy(
                                hasFeedBack = true,
                                feedBack = Pair(
                                    FeedBackType.ERROR,
                                    _state.value.error?.errorDescription.toString()
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    private fun validateRequestBodyState(value: String): String? {
        return if (value.isBlank() == true) {
            null
        } else {
            value
        }
    }

    private fun startLoading() {
        _state.update { currentState ->
            currentState.copy(
                isLoading = true
            )
        }
    }

    private fun stopLoading() {
        _state.update { currentState ->
            currentState.copy(
                isLoading = false
            )
        }
    }

}