package com.vr.mecali.di

import com.vr.mecali.modules.detail.viewmodel.DetailViewModel
import com.vr.mecali.modules.search.viewmodel.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchViewModel(get()) }
    viewModel { DetailViewModel(get(), get()) }
}