package com.voyager.presenter.screen.ride.request.screen


import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyager.R
import com.voyager.domain.model.ride.estimate.Option
import com.voyager.presenter.components.feedback.FeedbackUI
import com.voyager.presenter.components.formulary.DefaultButton
import com.voyager.presenter.components.formulary.DefaultTextView
import com.voyager.presenter.screen.ride.request.action.RideRequestAction
import com.voyager.presenter.screen.ride.request.state.RideRequestState
import com.voyager.presenter.screen.ride.request.viewModel.RideRequestViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun RideRequestScreen(
    navigateToRideConfirm: (Pair<String, List<Option>>) -> Unit
) {

    val viewModel = koinViewModel<RideRequestViewModel>()
    val state by viewModel.state.collectAsState()
    val action = viewModel::submitAction

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    RideRequestScreenContent(
        state = state,
        action = action,
        context = context,
        scope = scope,
        snackbarHostState = snackbarHostState,
        navigateToRideConfirm = navigateToRideConfirm
    )
}

@Composable
private fun RideRequestScreenContent(
    state: RideRequestState,
    action: (RideRequestAction) -> Unit,
    context: Context,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    navigateToRideConfirm: (Pair<String, List<Option>>) -> Unit
) {

    var originMenuExpanded = remember { mutableStateOf(false) }
    var destinationMenuExpanded = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    val originMenuLabel = remember { mutableIntStateOf(R.string.choose_origin_address) }
    val destinationMenuLabel = remember { mutableIntStateOf(R.string.choose_destination_address) }
    val addresses = listOf(
        R.string.pres_kenedy_address,
        R.string.paulista_address,
        R.string.thomas_edison_address,
        R.string.av_brasil_address,
        R.string.any_origin_address,
        R.string.any_destination_address
    )


    LaunchedEffect(
        originMenuExpanded.value,
        destinationMenuExpanded.value,
        state.hasFeedBack,
        state.rideEstimate?.options
    ) {
        if (originMenuExpanded.value) {
            scrollState.scrollTo(scrollState.maxValue)
        }
        if (destinationMenuExpanded.value) {
            scrollState.scrollTo(scrollState.maxValue)
        }

        scope.launch {
            if (state.hasFeedBack) {
                val result = snackbarHostState
                    .showSnackbar(
                        message = state.feedBack?.second
                            ?: context.getString(R.string.generic_error)
                    )
                if (result == SnackbarResult.Dismissed) {
                    action(RideRequestAction.ResetErrorState)
                }
            }
        }

        if (
            state.rideEstimate?.options?.isNotEmpty() == true
            && state.hasFeedBack == false
        ) {
            action(RideRequestAction.OnOptionsPopulate)
            navigateToRideConfirm(Pair(state.requestBody.customerId ?: "", state.rideEstimate.options))
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = { snackbarData ->
                    state.feedBack?.let { feedbackUI ->
                        FeedbackUI(
                            message = snackbarData.visuals.message,
                            type = feedbackUI.first
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            DefaultTextView(
                value = state.id,
                onValueChange = {
                    action(
                        RideRequestAction.ChangeName(
                            value = it
                        )
                    )
                },
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .height(58.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Green)
                    .clickable { originMenuExpanded.value = !originMenuExpanded.value },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(originMenuLabel.intValue),
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 19.sp,
                        textAlign = TextAlign.Center
                    )
                )
                DropdownMenu(
                    expanded = originMenuExpanded.value,
                    onDismissRequest = { originMenuExpanded.value = false },
                    scrollState = scrollState
                ) {
                    addresses.forEach { address ->
                        val chosenOrigin = stringResource(address)
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = stringResource(address),
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        lineHeight = 19.sp,
                                        textAlign = TextAlign.Center
                                    ),
                                )
                            },
                            onClick = {
                                originMenuLabel.intValue = address
                                originMenuExpanded.value = !originMenuExpanded.value
                                action(RideRequestAction.ChangeOrigin(address = chosenOrigin))
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_location_line),
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .height(58.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Green)
                    .clickable { destinationMenuExpanded.value = !destinationMenuExpanded.value },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(destinationMenuLabel.intValue),
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 19.sp,
                        textAlign = TextAlign.Center
                    )
                )

                DropdownMenu(
                    expanded = destinationMenuExpanded.value,
                    onDismissRequest = { destinationMenuExpanded.value = false },
                    scrollState = scrollState
                ) {
                    addresses.forEach { address ->
                        val chosenDestination = stringResource(address)
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = stringResource(address),
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        lineHeight = 19.sp,
                                        textAlign = TextAlign.Center
                                    ),
                                )
                            },
                            onClick = {
                                destinationMenuLabel.intValue = address
                                destinationMenuExpanded.value = !destinationMenuExpanded.value
                                action(RideRequestAction.ChangeDestination(address = chosenDestination))
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_location_line),
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
            }

            DefaultButton(
                modifier = Modifier
                    .padding(30.dp),
                onClick = {
                    action(RideRequestAction.GetRideEstimate)
                    action(RideRequestAction.OnRequestRideButtonClick)
                },
                text = stringResource(R.string.button_title_request_ride),
                isLoading = state.isLoading
            )
        }
    }

}

@PreviewLightDark
@Composable
private fun RideRequestScreenPreview() {
    RideRequestScreenContent(
        state = RideRequestState(),
        action = {},
        context = LocalContext.current,
        scope = rememberCoroutineScope(),
        snackbarHostState = remember { SnackbarHostState() },
        navigateToRideConfirm = {  },
    )
}