package com.voyager.data.remote.model.ride.response.estimate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OptionResponse (
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("vehicle")
    val vehicle: String? = null,
    @SerialName("review")
    val review: ReviewResponse? = null,
    @SerialName("value")
    val value: Double? = null,
)