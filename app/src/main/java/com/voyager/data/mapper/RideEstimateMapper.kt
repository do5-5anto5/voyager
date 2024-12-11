package com.voyager.data.mapper

import com.voyager.data.remote.model.ride.response.estimate.AddressResponse
import com.voyager.data.remote.model.ride.response.estimate.OptionResponse
import com.voyager.data.remote.model.ride.response.estimate.ReviewResponse
import com.voyager.data.remote.model.ride.response.estimate.RideEstimateResponse
import com.voyager.domain.model.ride.estimate.Address
import com.voyager.domain.model.ride.estimate.Option
import com.voyager.domain.model.ride.estimate.Review
import com.voyager.domain.model.ride.estimate.RideEstimate

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