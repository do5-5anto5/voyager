// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.voyager.data.model.ride_response.estimate

import kotlinx.serialization.SerialName

data class RideEstimateErrorResponse (

    @SerialName("error_description")
    val errorDescription: String,

    @SerialName("error_code")
    val errorCode: String
)
