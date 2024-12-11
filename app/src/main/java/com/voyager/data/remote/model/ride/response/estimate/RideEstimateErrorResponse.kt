package com.voyager.data.remote.model.ride.response.estimate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RideEstimateErrorResponse (
    @SerialName("error_code")
    val errorCode: String? = null,
    @SerialName("error_description")
    val errorDescription: String? = null
)