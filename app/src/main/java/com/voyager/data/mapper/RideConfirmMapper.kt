package com.voyager.data.mapper

import com.voyager.data.remote.model.ride.response.confirm.RideConfirmResponse
import com.voyager.domain.model.ride.confirm.RideConfirm

fun RideConfirmResponse.toDomain(): RideConfirm {
    return RideConfirm(
        success = success
    )
}