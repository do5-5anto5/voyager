package com.voyager.data.remote.model.ride.request.driver

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DriverRequestBody(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null
)