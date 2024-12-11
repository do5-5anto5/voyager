package com.voyager.domain.usecase

import com.voyager.data.model.mapper.toDomain
import com.voyager.data.remote.model.request_body.RideConfirmRequestBody
import com.voyager.domain.repository.RideRepository

class RideConfirmUseCase(
    private val repository: RideRepository
) {

    suspend operator fun invoke(body: RideConfirmRequestBody) = repository.confirmRide(body).toDomain()

}