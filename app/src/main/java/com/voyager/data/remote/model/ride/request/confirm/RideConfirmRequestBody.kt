package com.voyager.data.remote.model.ride.request.confirm

import com.voyager.data.remote.model.ride.request.driver.DriverRequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RideConfirmRequestBody(
    @SerialName("customer_id")
    val customerId: String? = null,
    @SerialName("origin")
    val origin: String? = null,
    @SerialName("destination")
    val destination: String? = null,
    @SerialName("distance")
    val distance: String? = null,
    @SerialName("duration")
    val duration: String? = null,
    @SerialName("driver")
    val driver: DriverRequestBody? = null,
    @SerialName("value")
    val value: String? = null
)