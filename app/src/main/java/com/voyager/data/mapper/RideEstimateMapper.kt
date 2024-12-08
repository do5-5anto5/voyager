package com.voyager.data.mapper

import com.voyager.data.model.ride_response.address.AddressResponse
import com.voyager.data.model.ride_response.estimate.OptionResponse
import com.voyager.data.model.ride_response.estimate.ReviewResponse
import com.voyager.data.model.ride_response.estimate.RideEstimateResponse
import com.voyager.domain.ride.address.Address
import com.voyager.domain.ride.estimate.Option
import com.voyager.domain.ride.estimate.Review
import com.voyager.domain.ride.estimate.RideEstimate

fun RideEstimateResponse.toDomain(): RideEstimate {
    return RideEstimate(
        origin = origin.toDomain(),
        destination = destination.toDomain(),
        distance = distance,
        duration = duration,
        options = options.map { it.toDomain() },
    routeResponse = routeResponse
    )
}

fun AddressResponse.toDomain(): Address {
    return Address(
        latitude = latitude,
        longitude = longitude
    )
}

fun OptionResponse.toDomain(): Option {
    return Option(
        id = id,
        name = name,
        description = description,
        vehicle = vehicle,
        review = review.toDomain(),
        value = value,
    )
}

fun ReviewResponse.toDomain(): Review {
    return Review(
        rating = rating,
        comment = comment
    )
}