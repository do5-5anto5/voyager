package com.voyager.presenter.screen.ride_request.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.voyager.data.remote.model.request_body.RideEstimateRequestBody
import com.voyager.presenter.components.DefaultButton
import com.voyager.presenter.screen.ride_request.action.RideRequestAction
import com.voyager.presenter.screen.ride_request.state.RideRequestState
import com.voyager.presenter.screen.ride_request.viewModel.RideRequestViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun RequestRideScreen() {

    val viewModel = koinViewModel<RideRequestViewModel>()
    val state by viewModel.state.collectAsState()
    val action = viewModel::submitAction

    RequestRideScreenContent(
        state = state,
        action = action
    )
}

@Composable
private fun RequestRideScreenContent(
    state: RideRequestState,
    action: (RideRequestAction) -> Unit
) {

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultButton(
                modifier = Modifier
                    .padding(40.dp),
                onClick = { action(RideRequestAction.GetRideEstimate(
                    RideEstimateRequestBody(
                        customerId = "CT01",
                        origin = "Av. Pres. Kenedy, 2385 - Remédios, Osasco - SP,02675-031",
                        destination = "Av. Paulista, 1538 - Bela Vista, São Paulo - SP, 01310-200"
                    )
                ))
                          },
                text = "Request Ride"
            )
        }
    }

}

@PreviewLightDark
@Composable
private fun RequestRideScreenPreview() {
    RequestRideScreenContent(
        state = RideRequestState(),
        action = {}
    )
}