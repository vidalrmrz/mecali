package com.vr.domain.entities

data class ItemEntity(
    val id: String,
    val siteId: String,
    val title: String,
    val seller: SellerEntity
)