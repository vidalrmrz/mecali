package com.vr.domain.entities

import java.io.Serializable

data class ItemEntity(
    val id: String = "",
    val siteId: String = "",
    val title: String = "",
    val seller: SellerEntity = SellerEntity(),
    val price: Long = 0,
    val thumbnail: String = "",
    val sold: String = "",
    val available: String = "",
    val currencyId: String = "",
    val permalink: String = ""
) : Serializable