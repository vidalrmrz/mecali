package com.vr.domain.entities

import java.io.Serializable

data class PictureEntity(
    val url: String,
    val secureUrl: String,
    val size: String
) : Serializable