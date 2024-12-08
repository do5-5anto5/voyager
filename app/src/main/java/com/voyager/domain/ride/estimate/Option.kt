package com.voyager.domain.ride.estimate

data class Option (
    val id: Int,
    val name: String,
    val description: String,
    val vehicle: String,
    val review: Review,
    val value: Int,
    )