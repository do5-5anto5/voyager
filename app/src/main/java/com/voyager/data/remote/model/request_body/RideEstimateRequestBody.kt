package com.voyager.data.remote.model.request_body

import com.google.gson.annotations.SerializedName

data class RideEstimateRequestBody(

    @SerializedName("customer_id")
    val customerId: String? = "",
    @SerializedName("origin")
    val origin: String? = "",
    @SerializedName("destination")
    val destination: String? = ""
)