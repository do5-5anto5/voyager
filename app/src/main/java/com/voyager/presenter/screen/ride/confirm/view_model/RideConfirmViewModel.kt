package com.voyager.presenter.screen.ride.confirm.view_model


import androidx.lifecycle.ViewModel
import com.voyager.presenter.screen.ride.confirm.action.RideConfirmAction
import com.voyager.presenter.screen.ride.confirm.state.RideConfirmState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RideConfirmViewModel : ViewModel() {

    private val _state = MutableStateFlow(RideConfirmState())
    val state = _state.asStateFlow()

    fun submitAction(action: RideConfirmAction) {

    }
}