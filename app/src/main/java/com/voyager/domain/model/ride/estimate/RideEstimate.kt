// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.voyager.domain.model.ride.estimate

import com.voyager.domain.model.ride.address.Address

data class RideEstimate(
    val origin: Address,
    val destination: Address,
    val distance: Int,
    val duration: String,
    val options: List<Option>,
    val routeResponse: String
)