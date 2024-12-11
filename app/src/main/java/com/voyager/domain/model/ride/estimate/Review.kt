package com.voyager.domain.model.ride.estimate

import kotlinx.serialization.Serializable

@Serializable
data class Review (
    val rating: Double? = null,
    val comment: String? = null
)