package com.voyager.presenter.screen.ride_options.screen


import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.voyager.presenter.screen.ride_options.state.RideOptionsState
import com.voyager.presenter.screen.ride_options.viewModel.RideOptionsViewModel
import com.voyager.presenter.screen.ride_options.action.RideOptionsAction

@Composable
fun RideOptionsScreen() {

    val viewModel = koinViewModel<RideOptionsViewModel>()
    val state by viewModel.state.collectAsState()
}

@Composable
private fun RideOptionsScreenContent(
    state: RideOptionsState,
    action: (RideOptionsAction) -> Unit
) {

}

@PreviewLightDark
@Composable
private fun RideOptionsScreenPreview() {
    RideOptionsScreenContent(
        state = RideOptionsState(),
        action = {}
    )
}