package com.vr.domain.usecases

import com.vr.domain.base.Either
import com.vr.domain.base.Failure
import com.vr.domain.entities.ItemEntity
import com.vr.domain.repositories.SearchRepository

class SearchUseCase(private val searchRepository: SearchRepository) :
    BaseUseCase<List<ItemEntity>, String> {

    override suspend fun run(params: String): Either<Failure, List<ItemEntity>> {
        return if (isQueryEnable(params)) {
            searchRepository.search(params)
        } else {
            Either.Right(listOf())
        }
    }

    private fun isQueryEnable(query: String) = query.trim().length > 3
}