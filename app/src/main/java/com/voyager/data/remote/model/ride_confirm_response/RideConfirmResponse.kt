package com.voyager.data.remote.model.ride_confirm_response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RideConfirmResponse(
    @SerialName("success")
    val success: Boolean
)
