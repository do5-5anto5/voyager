package com.voyager.presenter.screen.ride_request.screen


import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.voyager.presenter.screen.ride_request.state.RideRequestState
import com.voyager.presenter.screen.ride_request.viewModel.RideRequestViewModel
import com.voyager.presenter.screen.ride_request.action.RideRequestAction

@Composable
fun RequestRideScreen() {

    val viewModel = koinViewModel<RideRequestViewModel>()
    val state by viewModel.state.collectAsState()

}

@Composable
private fun RequestRideScreenContent(
    state: RideRequestState,
    action: (RideRequestAction) -> Unit
) {

}

@PreviewLightDark
@Composable
private fun RequestRideScreenPreview() {
    RequestRideScreenContent(
        state = RideRequestState(),
        action = {}
    )
}