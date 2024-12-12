package com.voyager.presenter.screen.ride.confirm.view_model


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voyager.data.remote.model.ride.request.confirm.RideConfirmRequestBody
import com.voyager.domain.model.ride.estimate.Option
import com.voyager.domain.usecase.RideConfirmUseCase
import com.voyager.presenter.screen.ride.confirm.action.RideConfirmAction
import com.voyager.presenter.screen.ride.confirm.state.RideConfirmState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RideConfirmViewModel(
    private val useCase: RideConfirmUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(RideConfirmState())
    val state = _state.asStateFlow()

    fun submitAction(action: RideConfirmAction) {
        when (action) {
            is RideConfirmAction.OptionSelected -> {
                confirmRide(action.driver)
            }

            is RideConfirmAction.OnLoad -> {
                onLoad()
            }
        }
    }

    private fun onLoad() {
        _state.value.options.forEach { option ->

            _state.update { currentState ->
                currentState.copy(
                    requestBody = RideConfirmRequestBody(

                    )
                )
            }
        }
    }

    private fun confirmRide(driver: Option) {
        viewModelScope.launch {
            try {
                startLoading()

                _state.update { currentState ->
                    currentState.copy(
                        requestBody = RideConfirmRequestBody(
                            customerId = validateRequestBodyState(currentState.id),
                            // change the state came from the previous screen than fill correctly the attributes
                        )
                    )
                }

                startLoading()
            } catch (e: HttpException) {

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