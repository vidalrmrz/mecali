package com.vr.data.dtos

import com.google.gson.annotations.SerializedName

data class ItemDto(
    val id: String,
    @SerializedName("site_id") val siteId: String,
    val title: String,
    val seller: SellerDto
)