package com.vr.domain.repositories

import com.vr.domain.base.Either
import com.vr.domain.base.Failure
import com.vr.domain.entities.ItemEntity

interface SearchRepository {
    suspend fun search(query: String): Either<Failure, List<ItemEntity>>
}