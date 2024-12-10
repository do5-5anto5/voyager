package com.voyager.data.remote.model.ride_estimate_response

import com.google.gson.annotations.SerializedName

data class RideEstimateResponse (
    @SerializedName("origin")
    val origin: AddressResponse?,
    @SerializedName("destination")
    val destination: AddressResponse?,
    @SerializedName("distance")
    val distance: Number?,
    @SerializedName("duration")
    val duration: String?,
    @SerializedName("options")
    val options: List<OptionResponse>?,
    @SerializedName("route_response")
    val routeResponse: String?
)

data class AddressResponse (
    @SerializedName("latitude")
    val latitude: Number?,
    @SerializedName("longitude")
    val longitude: Number?
)

data class OptionResponse (
    @SerializedName("id")
    val id: Number?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("vehicle")
    val vehicle: String?,
    @SerializedName("review")
    val review: ReviewResponse?,
    @SerializedName("value")
    val value: Number?,
)

data class ReviewResponse (
    @SerializedName("rating")
    val rating: Number?,
    @SerializedName("comment")
    val comment: String?
)

data class RideEstimateErrorResponse (
    @SerializedName("error_code")
    val errorCode: Number?,
    @SerializedName("error_description")
    val errorDescription: String?
)
