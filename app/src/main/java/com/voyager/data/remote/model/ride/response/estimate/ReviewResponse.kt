package com.voyager.data.remote.model.ride.response.estimate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponse (
    @SerialName("rating")
    val rating: Double? = null,
    @SerialName("comment")
    val comment: String? = null
)