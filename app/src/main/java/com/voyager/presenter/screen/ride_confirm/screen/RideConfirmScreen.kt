package com.voyager.presenter.screen.ride_confirm.screen


import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.voyager.presenter.screen.ride_confirm.action.RideConfirmAction
import com.voyager.presenter.screen.ride_confirm.state.RideConfirmState
import com.voyager.presenter.screen.ride_confirm.view_model.RideConfirmViewModel

@Composable
fun RideConfirmScreen() {

    val viewModel = koinViewModel<RideConfirmViewModel>()
    val state by viewModel.state.collectAsState()
}

@Composable
private fun RideConfirmScreenContent(
    state: RideConfirmState,
    action: (RideConfirmAction) -> Unit
) {

}

@PreviewLightDark
@Composable
private fun RideConfirmScreenPreview() {
    RideConfirmScreenContent(
        state = RideConfirmState(),
        action = {}
    )
}