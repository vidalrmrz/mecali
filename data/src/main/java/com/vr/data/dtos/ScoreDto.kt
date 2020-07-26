package com.vr.data.dtos

import com.google.gson.annotations.SerializedName
import com.vr.domain.entities.ScoreEntity

data class ScoreDto(
    @SerializedName("rating_average") val average: Long
)

fun ScoreDto.toEntity() = ScoreEntity(average)