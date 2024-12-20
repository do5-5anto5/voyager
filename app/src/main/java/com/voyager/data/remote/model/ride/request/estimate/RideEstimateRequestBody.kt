package com.voyager.data.remote.model.ride.request.estimate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RideEstimateRequestBody(

    @SerialName("customer_id")
    val customerId: String? = "",
    @SerialName("origin")
    val origin: String? = "",
    @SerialName("destination")
    val destination: String? = ""
)