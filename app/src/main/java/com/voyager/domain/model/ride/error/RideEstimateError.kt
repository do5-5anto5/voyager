package com.voyager.domain.model.ride.error

import kotlinx.serialization.Serializable

@Serializable
data class RideEstimateError(
    val errorCode: String?,
    val errorDescription: String?
)
