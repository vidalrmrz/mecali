package com.vr.domain.repositories

import com.vr.domain.base.Either
import com.vr.domain.base.Failure
import com.vr.domain.entities.ItemDetailEntity
import com.vr.domain.entities.ItemEntity
import com.vr.domain.entities.ScoreEntity

interface SearchRepository {
    suspend fun search(query: String): Either<Failure, List<ItemEntity>>
    suspend fun review(id: String): Either<Failure, ScoreEntity>
    suspend fun itemDetail(id: String): Either<Failure, ItemDetailEntity>
}