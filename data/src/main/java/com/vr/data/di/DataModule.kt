package com.vr.data.di

import com.vr.data.repositories.SearchRepositoryImpl
import com.vr.domain.repositories.SearchRepository
import org.koin.dsl.module

val dataModule = module {
    single<SearchRepository> { SearchRepositoryImpl(get()) }
}