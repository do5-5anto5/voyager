package com.voyager.data.remote.model.request_body

import com.google.gson.annotations.SerializedName

data class RideConfirmRequestBody(
    @SerializedName("customer_id")
    val customerId: String,
    @SerializedName("destination")
    val destination: String,
    @SerializedName("distance")
    val distance: String,
    @SerializedName("driver")
    val driver: DriverRequestBody,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("value")
    val value: String
)