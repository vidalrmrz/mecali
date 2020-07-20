package com.vr.mecali.modules.search.viewmodel

import androidx.lifecycle.viewModelScope
import com.vr.domain.usecases.SearchUseCase
import com.vr.mecali.common.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(private val searchUseCase: SearchUseCase) : BaseViewModel() {

    fun excecuteSearch(query: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                searchUseCase.run(query).fold({}, {})
            }
        }
    }
}