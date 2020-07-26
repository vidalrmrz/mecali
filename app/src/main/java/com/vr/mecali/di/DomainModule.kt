package com.vr.mecali.di

import com.vr.domain.usecases.ItemDetailUseCase
import com.vr.domain.usecases.ScoreUseCase
import com.vr.domain.usecases.SearchUseCase
import org.koin.dsl.module

val domainModule = module {
    single { SearchUseCase(get()) }
    single { ScoreUseCase(get()) }
    single { ItemDetailUseCase(get()) }
}