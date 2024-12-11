package com.voyager.presenter.screen.ride.confirm.state

import com.voyager.domain.model.ride.estimate.Option


data class RideConfirmState(
    val isLoading: Boolean = false,
    val options: List<Option> = emptyList()
)