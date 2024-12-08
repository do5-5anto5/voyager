package com.voyager.data.model.ride_response.estimate

import kotlinx.serialization.SerialName

data class ReviewResponse (

    @SerialName("rating")
    val rating: Int,

    @SerialName("comment")
    val comment: String
)