// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.voyager.data.model.ride_response.estimate

import com.voyager.data.model.ride_response.address.AddressResponse
import kotlinx.serialization.SerialName

data class RideEstimateResponse (

    @SerialName("origin")
    val origin: AddressResponse,

    @SerialName("destination")
    val destination: AddressResponse,

    @SerialName("distance")
    val distance: Int,

    @SerialName("duration")
    val duration: String,

    @SerialName("options")
    val options: List<OptionResponse>,

    @SerialName("routeResponse")
    val routeResponse: String
)