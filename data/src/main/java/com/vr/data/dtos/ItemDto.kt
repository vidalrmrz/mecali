package com.vr.data.dtos

import com.google.gson.annotations.SerializedName
import com.vr.domain.entities.ItemEntity

data class ItemDto(
    val id: String,
    @SerializedName("site_id") val siteId: String,
    val title: String,
    val seller: SellerDto,
    val price: Long,
    val thumbnail: String,
    @SerializedName("sold_quantity") val soldQuantity: String,
    @SerializedName("available_quantity") val availableQuantity: String,
    @SerializedName("currency_id") val currencyId: String,
    val permalink: String
)

fun ItemDto.toEntity() = ItemEntity(
    id,
    siteId,
    title,
    seller.toEntity(),
    price,
    thumbnail,
    soldQuantity,
    availableQuantity,
    currencyId,
    permalink
)