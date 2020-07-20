package com.vr.domain.usecases

import com.vr.domain.base.Either
import com.vr.domain.base.Failure

interface BaseUseCase<out Type, in Params> where Type : Any {
    suspend fun run(params: Params): Either<Failure, Type>
}