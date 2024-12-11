package com.voyager.data.remote.model.ride.response.estimate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RideEstimateResponse (
    @SerialName("origin")
    val origin: AddressResponse? = null,
    @SerialName("destination")
    val destination: AddressResponse? = null,
    @SerialName("distance")
    val distance: Double? = null,
    @SerialName("duration")
    val duration: Double? = null,
    @SerialName("options")
    val options: List<OptionResponse>? = null,
    @SerialName("route_response")
    val routeResponse: String? = null
)

//@Serializable
//data class AddressResponse (
//    @SerialName("latitude")
//    val latitude: Double? = null,
//    @SerialName("longitude")
//    val longitude: Double? = null
//)

//@Serializable
//data class OptionResponse (
//    @SerialName("id")
//    val id: Int? = null,
//    @SerialName("name")
//    val name: String? = null,
//    @SerialName("description")
//    val description: String? = null,
//    @SerialName("vehicle")
//    val vehicle: String? = null,
//    @SerialName("review")
//    val review: ReviewResponse? = null,
//    @SerialName("value")
//    val value: Double? = null,
//)

//@Serializable
//data class ReviewResponse (
//    @SerialName("rating")
//    val rating: Double? = null,
//    @SerialName("comment")
//    val comment: String? = null
//)

//@Serializable
//data class RideEstimateErrorResponse (
//    @SerialName("error_code")
//    val errorCode: String? = null,
//    @SerialName("error_description")
//    val errorDescription: String? = null
//)
