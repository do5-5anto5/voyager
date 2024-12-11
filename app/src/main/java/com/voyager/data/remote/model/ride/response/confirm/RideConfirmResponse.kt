package com.voyager.data.remote.model.ride.response.confirm

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RideConfirmResponse(
    @SerialName("success")
    val success: Boolean
)
