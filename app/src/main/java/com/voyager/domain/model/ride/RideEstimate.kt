package com.voyager.domain.model.ride

data class RideEstimate (
    val origin: Address?,
    val destination: Address?,
    val distance: Number?,
    val duration: String?,
    val options: List<Option>?,
    val routeResponse: String?
)

data class Address (
    val latitude: Number?,
    val longitude: Number?
)

data class Option (
    val id: Number?,
    val name: String?,
    val description: String?,
    val vehicle: String?,
    val review: Review?,
    val value: Number?
)

data class Review (
    val rating: Number?,
    val comment: String?
)
