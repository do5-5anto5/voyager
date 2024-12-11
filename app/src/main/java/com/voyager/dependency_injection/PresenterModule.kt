package com.voyager.dependency_injection

import com.voyager.presenter.screen.ride_history.viewModel.RideHistoryViewModel
import com.voyager.presenter.screen.ride_confirm.view_model.RideConfirmViewModel
import com.voyager.presenter.screen.ride_request.viewModel.RideRequestViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {
    viewModel {
        RideRequestViewModel(
            useCase = get()
        )
    }

    viewModel {
        RideConfirmViewModel()
    }

    viewModel {
        RideHistoryViewModel()
    }
}
