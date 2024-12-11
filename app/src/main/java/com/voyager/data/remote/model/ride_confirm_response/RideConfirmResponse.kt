package com.voyager.data.remote.model.ride_confirm_response

import com.google.gson.annotations.SerializedName

data class RideConfirmResponse(
    @SerializedName("success")
    val success: Boolean
)
