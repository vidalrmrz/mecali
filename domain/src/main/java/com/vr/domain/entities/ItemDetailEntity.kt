package com.vr.domain.entities

import java.io.Serializable

data class ItemDetailEntity(
    val pictures : List<PictureEntity>
) : Serializable