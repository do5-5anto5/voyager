package com.voyager.data.remote.model.request_body

import com.google.gson.annotations.SerializedName

data class DriverRequestBody(
    @SerializedName("id")
    val id: Number? = null,
    val name: String? = ""
)