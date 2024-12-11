package com.voyager.domain.model.ride.estimate

import kotlinx.serialization.Serializable

@Serializable
data class Option (
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val vehicle: String? = null,
    val review: Review? = null,
    val value: Double? = null
)