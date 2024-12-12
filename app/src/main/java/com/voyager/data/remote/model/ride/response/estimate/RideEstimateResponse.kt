package com.voyager.data.remote.model.ride.response.estimate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RideEstimateResponse (
    @SerialName("origin")
    val origin: AddressResponse? = null,
    @SerialName("destination")
    val destination: AddressResponse? = null,
    @SerialName("distance")
    val distance: Double? = null,
    @SerialName("duration")
    val duration: Double? = null,
    @SerialName("options")
    val options: List<OptionResponse>? = null,
    @SerialName("route_response")
    val routeResponse: String? = null
)
