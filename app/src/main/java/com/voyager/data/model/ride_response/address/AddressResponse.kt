package com.voyager.data.model.ride_response.address

import kotlinx.serialization.SerialName

data class AddressResponse (

    @SerialName("latitude")
    val latitude: Int,

    @SerialName("longitude")
    val longitude: Int
)
