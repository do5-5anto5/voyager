package com.voyager.dependency_injection

import com.voyager.presenter.screen.ride_history.viewModel.RideHistoryViewModel
import com.voyager.presenter.screen.ride_options.viewModel.RideOptionsViewModel
import com.voyager.presenter.screen.ride_request.viewModel.RideRequestViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {
    viewModel {
        RideRequestViewModel()
    }

    viewModel {
        RideOptionsViewModel()
    }

    viewModel {
        RideHistoryViewModel()
    }
}
