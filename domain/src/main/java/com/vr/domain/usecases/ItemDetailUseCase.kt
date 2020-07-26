package com.vr.domain.usecases

import com.vr.domain.base.Either
import com.vr.domain.base.Failure
import com.vr.domain.entities.ItemDetailEntity
import com.vr.domain.entities.ItemEntity
import com.vr.domain.repositories.SearchRepository

class ItemDetailUseCase(private val searchRepository: SearchRepository) :
    BaseUseCase<ItemDetailEntity, String> {

    override suspend fun run(params: String): Either<Failure, ItemDetailEntity> {
        return searchRepository.itemDetail(params)
    }

}