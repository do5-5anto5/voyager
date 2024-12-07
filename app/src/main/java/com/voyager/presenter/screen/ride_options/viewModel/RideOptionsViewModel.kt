package com.voyager.presenter.screen.ride_options.viewModel


import androidx.lifecycle.ViewModel
import com.voyager.presenter.screen.ride_options.action.RideOptionsAction
import com.voyager.presenter.screen.ride_options.state.RideOptionsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RideOptionsViewModel : ViewModel() {

    private val _state = MutableStateFlow(RideOptionsState())
    val state = _state.asStateFlow()

    fun submitAction(action: RideOptionsAction) {

    }
}