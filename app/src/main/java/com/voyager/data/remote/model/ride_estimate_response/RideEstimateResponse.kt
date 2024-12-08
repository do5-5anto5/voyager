package com.voyager.data.remote.model.ride_estimate_response

import com.google.gson.annotations.SerializedName

data class RideEstimateResponse (
    @SerializedName("duration")
    val duration: String,
    @SerializedName("distance")
    val distance: String,
    @SerializedName("origin")
    val origin: AddressResponse,
    @SerializedName("route_response")
    val routeResponse: String,
    @SerializedName("destination")
    val destination: AddressResponse,
    @SerializedName("options")
    val options: List<OptionResponse>
)

data class AddressResponse (
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String
)

data class OptionResponse (
    @SerializedName("review")
    val review: ReviewResponse,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("value")
    val value: String,
    @SerializedName("vehicle")
    val vehicle: String
)

data class ReviewResponse (
    @SerializedName("rating")
    val rating: String,
    @SerializedName("comment")
    val comment: String
)
