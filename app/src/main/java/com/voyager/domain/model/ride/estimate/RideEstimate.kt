package com.voyager.domain.model.ride.estimate

import kotlinx.serialization.Serializable

@Serializable
data class RideEstimate (
    val origin: Address? = null,
    val destination: Address? = null,
    val distance: Double? = null,
    val duration: Double? = null,
    val options: List<Option>? = emptyList<Option>(),
    val routeResponse: String? = null
)
