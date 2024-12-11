package com.voyager.core.navigation.routes

import kotlinx.serialization.Serializable

@Serializable
sealed class AppRoutes {


    @Serializable
    data object RideRequestRoute : AppRoutes()


    @Serializable
    data object RideConfirmRoute : AppRoutes()


    @Serializable
    data object RideHistoryRoute : AppRoutes()

}