package com.voyager.presenter.screen.ride.history.viewModel


import androidx.lifecycle.ViewModel
import com.voyager.presenter.screen.ride.history.action.RideHistoryAction
import com.voyager.presenter.screen.ride.history.state.RideHistoryState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RideHistoryViewModel : ViewModel() {

    private val _state = MutableStateFlow(RideHistoryState())
    val state = _state.asStateFlow()

    fun submitAction(action: RideHistoryAction) {

    }
}