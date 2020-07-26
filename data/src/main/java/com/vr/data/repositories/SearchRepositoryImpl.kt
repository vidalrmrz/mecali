package com.vr.data.repositories

import com.vr.data.dtos.toEntity
import com.vr.data.network.SearchApi
import com.vr.domain.base.Either
import com.vr.domain.base.Failure
import com.vr.domain.entities.ItemDetailEntity
import com.vr.domain.entities.ItemEntity
import com.vr.domain.entities.ScoreEntity
import com.vr.domain.repositories.SearchRepository

class SearchRepositoryImpl(private val searchApi: SearchApi) : SearchRepository {
    override suspend fun search(query: String): Either<Failure, List<ItemEntity>> {
        return try {
            val result = searchApi.getItems(query)
            Either.Right(result.blockingGet().results.map {
                it.toEntity()
            })
        } catch (e: Exception) {
            Either.Left(Failure.analyzeException(e))
        }
    }

    override suspend fun review(id: String): Either<Failure, ScoreEntity> {
        return try {
            val result = searchApi.getItemScore(id)
            Either.Right(result.blockingGet().toEntity())
        } catch (e: Exception) {
            Either.Left(Failure.analyzeException(e))
        }
    }

    override suspend fun itemDetail(id: String): Either<Failure, ItemDetailEntity> {
        return try {
            val result = searchApi.getItemDetail(id)
            Either.Right(result.blockingGet().toEntity())
        } catch (e: Exception) {
            Either.Left(Failure.analyzeException(e))
        }
    }
}