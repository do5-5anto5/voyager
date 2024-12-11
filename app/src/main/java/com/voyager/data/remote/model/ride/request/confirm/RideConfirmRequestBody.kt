package com.voyager.data.remote.model.ride.request.confirm

import com.voyager.data.remote.model.ride.request.driver.DriverRequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RideConfirmRequestBody(
    @SerialName("customer_id")
    val customerId: String,
    @SerialName("destination")
    val destination: String,
    @SerialName("distance")
    val distance: String,
    @SerialName("driver")
    val driver: DriverRequestBody,
    @SerialName("duration")
    val duration: String,
    @SerialName("origin")
    val origin: String,
    @SerialName("value")
    val value: String
)