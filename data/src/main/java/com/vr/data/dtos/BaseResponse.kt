package com.vr.data.dtos

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("site_id") val siteId: String,
    val paging: PagingDto,
    val results: List<T>
)