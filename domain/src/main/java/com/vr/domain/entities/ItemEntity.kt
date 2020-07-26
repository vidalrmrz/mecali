package com.vr.domain.entities

import java.io.Serializable

data class ItemEntity(
    val id: String,
    val siteId: String,
    val title: String,
    val seller: SellerEntity,
    val price: Long,
    val thumbnail: String,
    val sold: String,
    val available: String,
    val currencyId: String,
    val permalink: String
) : Serializable