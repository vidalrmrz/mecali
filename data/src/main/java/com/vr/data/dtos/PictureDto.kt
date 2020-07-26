package com.vr.data.dtos

import com.google.gson.annotations.SerializedName
import com.vr.domain.entities.PictureEntity

data class PictureDto(
    val url: String,
    @SerializedName("secure_url") val secureUrl: String,
    val size: String
)

fun PictureDto.toEntity() = PictureEntity(url, secureUrl, size)