package com.voyager.data.model.mapper

import com.voyager.data.remote.model.ride_estimate_response.AddressResponse
import com.voyager.data.remote.model.ride_estimate_response.OptionResponse
import com.voyager.data.remote.model.ride_estimate_response.ReviewResponse
import com.voyager.data.remote.model.ride_estimate_response.RideEstimateResponse
import com.voyager.domain.model.ride.Address
import com.voyager.domain.model.ride.Option
import com.voyager.domain.model.ride.Review
import com.voyager.domain.model.ride.RideEstimate

fun RideEstimateResponse.toDomain(): RideEstimate {
    return RideEstimate(
        origin = origin?.toDomain(),
        destination = destination?.toDomain(),
        distance = distance,
        duration = duration,
        options = options?.map { it.toDomain() },
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
        review = review?.toDomain(),
        name= name,
        description= description,
        id = id,
        vehicle= vehicle,
        value= value
    )
}

fun ReviewResponse.toDomain(): Review {
    return Review(
        rating = rating,
        comment = comment
    )
}