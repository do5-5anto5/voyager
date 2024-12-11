package com.voyager.domain.model.ride.estimate

import kotlinx.serialization.Serializable

@Serializable
data class Address (
    val latitude: Double? = null,
    val longitude: Double? = null
)