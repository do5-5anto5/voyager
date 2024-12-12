package com.voyager.core.navigation.host

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.TransformOrigin
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.voyager.core.navigation.routes.AppRoutes
import com.voyager.domain.model.ride.estimate.Option
import com.voyager.presenter.screen.ride.confirm.screen.RideConfirmScreen
import com.voyager.presenter.screen.ride.history.screen.RideHistoryScreen
import com.voyager.presenter.screen.ride.request.screen.RideRequestScreen

@Composable
fun AppNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = AppRoutes.RideRequestRoute
    ) {
        composable<AppRoutes.RideRequestRoute>(
            enterTransition = {
                scaleIn(
                    animationSpec = spring(
                        stiffness = Spring.StiffnessVeryLow,
                        dampingRatio = Spring.DampingRatioLowBouncy
                    ),
                    initialScale = 0f,
                    transformOrigin = TransformOrigin(0.5f, 0.5f)
                )
            }
        ) { backStackEntry ->
            RideRequestScreen(
                navigateToRideConfirm = { options ->
                    backStackEntry.savedStateHandle.set("options", options)
                    navHostController.navigate(AppRoutes.RideConfirmRoute)
                })
        }
        composable<AppRoutes.RideConfirmRoute>(
            enterTransition = {
                scaleIn(
                    animationSpec = spring(
                        stiffness = Spring.StiffnessVeryLow,
                        dampingRatio = Spring.DampingRatioLowBouncy
                    ),
                    initialScale = 0f,
                    transformOrigin = TransformOrigin(0.5f, 0.5f)
                )
            }
        ) { backStackEntry ->
            val previousBackStackEntry = navHostController.previousBackStackEntry
            val options = previousBackStackEntry?.savedStateHandle?.get<List<Option>>("options")
            RideConfirmScreen(
                options = options ?: emptyList()
            )
        }
        composable<AppRoutes.RideHistoryRoute>(
            enterTransition = {
                scaleIn(
                    animationSpec = spring(
                        stiffness = Spring.StiffnessVeryLow,
                        dampingRatio = Spring.DampingRatioLowBouncy
                    ),
                    initialScale = 0f,
                    transformOrigin = TransformOrigin(0.5f, 0.5f)
                )
            }
        ) {
            RideHistoryScreen()
        }
    }
}