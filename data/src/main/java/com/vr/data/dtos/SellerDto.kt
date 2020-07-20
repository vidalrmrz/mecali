package com.vr.data.dtos

import com.google.gson.annotations.SerializedName
import com.vr.domain.entities.SellerEntity

data class SellerDto(
    val id: Long,
    @SerializedName("car_dealer") val cardDealer: Boolean,
    @SerializedName("real_estate_agency") val realEstateAgency: Boolean
)

fun SellerDto.toEntity() = SellerEntity(
    id, cardDealer, realEstateAgency
)