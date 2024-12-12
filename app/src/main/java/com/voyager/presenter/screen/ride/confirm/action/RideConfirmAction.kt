package com.voyager.presenter.screen.ride.confirm.action

import com.voyager.domain.model.ride.estimate.Option


sealed class RideConfirmAction {
    data object OnLoad : RideConfirmAction()
    data class OptionSelected(val driver: Option) : RideConfirmAction()
}