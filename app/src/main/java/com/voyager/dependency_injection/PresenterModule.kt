package com.voyager.dependency_injection

import com.voyager.presenter.screen.ride.history.viewModel.RideHistoryViewModel
import com.voyager.presenter.screen.ride.confirm.view_model.RideConfirmViewModel
import com.voyager.presenter.screen.ride.request.viewModel.RideRequestViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {
    viewModel {
        RideRequestViewModel(
            useCase = get()
        )
    }

    viewModel {
        RideConfirmViewModel(
            useCase = get()
        )
    }

    viewModel {
        RideHistoryViewModel()
    }
}
