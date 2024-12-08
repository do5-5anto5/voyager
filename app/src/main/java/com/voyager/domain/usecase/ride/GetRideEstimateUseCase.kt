package com.voyager.domain.usecase.ride

import com.voyager.data.mapper.toDomain
import com.voyager.domain.model.ride.estimate.RideEstimate
import com.voyager.domain.repository.ride.RideRepository

class GetRideEstimateUseCase(
    private val repository : RideRepository
) {

    suspend operator fun invoke(
        customerId: String?,
        origin: String?,
        destination: String?
    ) : RideEstimate {
        return repository.getRideEstimate(customerId, origin, destination)
            .toDomain()
    }

}