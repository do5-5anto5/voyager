package com.voyager.domain.model.ride.error

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RideEstimateError(
    val errorCode: Number?,
    val errorDescription: String?
) : Parcelable
