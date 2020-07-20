package com.vr.data.dtos

import com.google.gson.annotations.SerializedName
import com.vr.domain.entities.ItemEntity

data class ItemDto(
    val id: String,
    @SerializedName("site_id") val siteId: String,
    val title: String,
    val seller: SellerDto
)

fun ItemDto.toEntity() = ItemEntity(
    id, siteId, title, seller.toEntity()
)