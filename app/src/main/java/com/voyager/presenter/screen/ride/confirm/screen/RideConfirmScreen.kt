package com.voyager.presenter.screen.ride.confirm.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.voyager.domain.model.ride.estimate.Option
import com.voyager.presenter.screen.ride.confirm.action.RideConfirmAction
import com.voyager.presenter.screen.ride.confirm.state.RideConfirmState
import com.voyager.presenter.screen.ride.confirm.view_model.RideConfirmViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun RideConfirmScreen(
    options: List<Option>
) {
    val viewModel = koinViewModel<RideConfirmViewModel>()
    val state by viewModel.state.collectAsState()
    val action = viewModel::submitAction

    RideConfirmScreenContent(
        state = state,
        action = action,
        options = options
    )

}

@Composable
private fun RideConfirmScreenContent(
    state: RideConfirmState,
    action: (RideConfirmAction) -> Unit,
    options: List<Option>
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // mock presentation showing options
        Text("${options.size}")

        options.forEach { option ->
            Text("${option.name}")
        }

    }
}

@PreviewLightDark
@Composable
private fun RideConfirmScreenPreview() {
    RideConfirmScreenContent(
        state = RideConfirmState(),
        action = {},
        options = emptyList()
    )
}