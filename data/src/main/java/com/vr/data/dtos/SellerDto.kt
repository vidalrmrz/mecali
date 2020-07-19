package com.vr.data.dtos

import com.google.gson.annotations.SerializedName

data class SellerDto(
    val id: Long,
    @SerializedName("power_seller_status") val powerStatus: String,
    @SerializedName("car_dealer") val cardDealer: Boolean,
    @SerializedName("real_estate_agency") val realEstateAgency: Boolean
)