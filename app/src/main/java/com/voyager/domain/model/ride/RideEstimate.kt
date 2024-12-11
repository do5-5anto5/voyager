package com.voyager.domain.model.ride

import kotlinx.serialization.Serializable

@Serializable
data class RideEstimate (
    val origin: Address? = null,
    val destination: Address? = null,
    val distance: Double? = null,
    val duration: Double? = null,
    val options: List<Option>? = emptyList<Option>(),
    val routeResponse: String? = null,
)

@Serializable
data class Address (
    val latitude: Double? = null,
    val longitude: Double? = null
)

@Serializable
data class Option (
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val vehicle: String? = null,
    val review: Review? = null,
    val value: Double? = null
)

@Serializable
data class Review (
    val rating: Double? = null,
    val comment: String? = null
)
