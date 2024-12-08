package com.voyager.data.model.ride_response.estimate

import kotlinx.serialization.SerialName

data class OptionResponse (

    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("description")
    val description: String,

    @SerialName("vehicle")
    val vehicle: String,

    @SerialName("review")
    val review: ReviewResponse,

    @SerialName("value")
    val value: Int,
)