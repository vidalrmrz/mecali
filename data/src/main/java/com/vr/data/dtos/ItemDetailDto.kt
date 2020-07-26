package com.vr.data.dtos

import com.vr.domain.entities.ItemDetailEntity
import com.vr.domain.entities.PictureEntity

data class ItemDetailDto(
    val pictures: List<PictureEntity>
)

fun ItemDetailDto.toEntity() = ItemDetailEntity(pictures)