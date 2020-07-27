package com.vr.mecali.modules.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vr.domain.entities.ItemEntity
import com.vr.domain.usecases.SearchUseCase
import com.vr.mecali.common.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(private val searchUseCase: SearchUseCase) : BaseViewModel() {

    private var _searchList = MutableLiveData(listOf<ItemEntity>())
    val searchList: LiveData<List<ItemEntity>> get() = _searchList

    fun executeSearch(query: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                searchUseCase.run(query).fold({

                }, {
                    val items = mutableListOf<ItemEntity>()
                    items.addAll(it)
                    _searchList.postValue(items)
                })
            }
        }
    }
}