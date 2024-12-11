package com.voyager.presenter.screen.ride.history.screen


import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.voyager.presenter.screen.ride.history.action.RideHistoryAction
import com.voyager.presenter.screen.ride.history.state.RideHistoryState
import com.voyager.presenter.screen.ride.history.viewModel.RideHistoryViewModel

@Composable
fun RideHistoryScreen() {

    val viewModel = koinViewModel<RideHistoryViewModel>()
    val state by viewModel.state.collectAsState()
}

@Composable
private fun RideHistoryScreenContent(
    state: RideHistoryState,
    action: (RideHistoryAction) -> Unit
) {

}

@PreviewLightDark
@Composable
private fun RideHistoryScreenPreview() {
    RideHistoryScreenContent(
        state = RideHistoryState(),
        action = {}
    )
}