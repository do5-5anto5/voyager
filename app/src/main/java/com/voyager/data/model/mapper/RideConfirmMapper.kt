package com.voyager.data.model.mapper

import com.voyager.data.remote.model.ride_confirm_response.RideConfirmResponse
import com.voyager.domain.model.ride.confirm.RideConfirm

fun RideConfirmResponse.toDomain(): RideConfirm {
    return RideConfirm(
        success = success
    )
}