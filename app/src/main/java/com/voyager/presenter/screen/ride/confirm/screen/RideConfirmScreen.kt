package com.voyager.presenter.screen.ride.confirm.screen


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.LatLng
import com.voyager.R
import com.voyager.domain.model.ride.estimate.Option
import com.voyager.presenter.components.driver.DriverCard
import com.voyager.presenter.components.google_map.GoogleMapUI
import com.voyager.presenter.screen.ride.confirm.action.RideConfirmAction
import com.voyager.presenter.screen.ride.confirm.state.RideConfirmState
import com.voyager.presenter.screen.ride.confirm.view_model.RideConfirmViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun RideConfirmScreen(
    customerIdAndOptions: Pair<String, List<Option>>,
) {
    val viewModel = koinViewModel<RideConfirmViewModel>()
    val state by viewModel.state.collectAsState()
    val action = viewModel::submitAction

    RideConfirmScreenContent(
        state = state,
        action = action,
        options = customerIdAndOptions.second
    )

}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun RideConfirmScreenContent(
    state: RideConfirmState,
    action: (RideConfirmAction) -> Unit,
    options: List<Option>,

) {

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            GoogleMapUI(
                latitudeLongitude = LatLng(-23.563794599999998, -46.6576656),
                title = "Voyager"
            )

            Text(
                text = stringResource(R.string.title_choose_option),
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    lineHeight = 19.6.sp,
                    letterSpacing = 0.2.sp
                )
            )

            Spacer(modifier = Modifier.padding(6.dp))

            LazyColumn(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .border(2.dp, Color.Gray, RoundedCornerShape(16.dp)),
            ) {
                items(options.size) { driver ->
                    DriverCard(
                        driver = options[driver],
                        onClick = { action(RideConfirmAction.OptionSelected(options[driver])) }
                    )
                }
            }

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