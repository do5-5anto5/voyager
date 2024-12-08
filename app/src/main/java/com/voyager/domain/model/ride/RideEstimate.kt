package com.voyager.domain.model.ride

data class RideEstimate (
    val duration: String,
    val distance: String,
    val origin: Address,
    val routeResponse: String,
    val destination: Address,
    val options: List<Option>
)

data class Address (
    val latitude: String,
    val longitude: String
)

data class Option (
    val review: Review,
    val name: String,
    val description: String,
    val id: String,
    val value: String,
    val vehicle: String
)

data class Review (
    val rating: String,
    val comment: String
)
