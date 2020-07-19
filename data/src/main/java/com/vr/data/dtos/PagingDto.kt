package com.vr.data.dtos

import com.google.gson.annotations.SerializedName

data class PagingDto(
    val total: Long,
    val offset: Int,
    val limit: Int,
    @SerializedName("primary_results") val primaryResults: Long
)