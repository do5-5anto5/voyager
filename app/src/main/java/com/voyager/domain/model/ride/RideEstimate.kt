package com.voyager.domain.model.ride

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RideEstimate (
    val origin: Address? = null,
    val destination: Address? = null,
    val distance: Number? = null,
    val duration: String? = null,
    val options: List<Option>? = emptyList<Option>(),
    val routeResponse: String? = null,
) : Parcelable

@Parcelize
data class Address (
    val latitude: Number? = null,
    val longitude: Number? = null
) : Parcelable

@Parcelize
data class Option (
    val id: Number? = null,
    val name: String? = null,
    val description: String? = null,
    val vehicle: String? = null,
    val review: Review? = null,
    val value: Number? = null
) : Parcelable

@Parcelize
data class Review (
    val rating: Number? = null,
    val comment: String? = null
) : Parcelable
