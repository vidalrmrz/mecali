package com.vr.data.dtos

import com.vr.domain.entities.ItemDetailEntity

data class ItemDetailDto(
    val pictures: List<PictureDto>
)

fun ItemDetailDto.toEntity() = ItemDetailEntity(pictures.map { it.toEntity() })