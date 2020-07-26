package com.vr.domain.usecases

import com.vr.domain.base.Either
import com.vr.domain.base.Failure
import com.vr.domain.entities.ScoreEntity
import com.vr.domain.repositories.SearchRepository

class ScoreUseCase(private val searchRepository: SearchRepository) :
    BaseUseCase<ScoreEntity, String> {

    override suspend fun run(params: String): Either<Failure, ScoreEntity> {
        return searchRepository.review(params)
    }

}