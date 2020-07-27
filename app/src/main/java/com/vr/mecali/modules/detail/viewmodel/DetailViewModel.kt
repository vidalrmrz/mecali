package com.vr.mecali.modules.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vr.domain.entities.ItemEntity
import com.vr.domain.entities.PictureEntity
import com.vr.domain.usecases.ItemDetailUseCase
import com.vr.domain.usecases.ScoreUseCase
import com.vr.mecali.common.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class DetailViewModel(
    private val scoreUseCase: ScoreUseCase,
    private val itemDetailUseCase: ItemDetailUseCase,
    private val ioContext: CoroutineContext = Dispatchers.IO
) :
    BaseViewModel() {
    private val _itemDetail = MutableLiveData<ItemEntity>()
    val itemDetail: LiveData<ItemEntity> get() = _itemDetail

    private val _itemScore = MutableLiveData<String>()
    val itemScore: LiveData<String> get() = _itemScore

    private val _pictures = MutableLiveData<List<PictureEntity>>()
    val pictures: LiveData<List<PictureEntity>> get() = _pictures

    fun setDetailItem(itemEntity: ItemEntity) {
        _itemDetail.value = itemEntity
        viewModelScope.launch {
            withContext(ioContext) {
                scoreUseCase.run(itemEntity.id).fold({}, {
                    _itemScore.postValue(it.average.toString())
                })
                itemDetailUseCase.run(itemEntity.id).fold({}, {
                    _pictures.postValue(it.pictures)
                })
            }
        }
    }
}