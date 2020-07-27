package com.vr.mecali.modules.detail.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.vr.domain.base.Either
import com.vr.domain.entities.ItemEntity
import com.vr.domain.entities.ScoreEntity
import com.vr.domain.usecases.ItemDetailUseCase
import com.vr.domain.usecases.ScoreUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    @Mock
    lateinit var scoreUseCase: ScoreUseCase

    @Mock
    lateinit var itemDetailUseCase: ItemDetailUseCase

    @Mock
    lateinit var itemObserver: Observer<ItemEntity>

    private lateinit var sut: DetailViewModel
    private val mainThreadSurrogate = newSingleThreadContext("IO thread")

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        sut = DetailViewModel(scoreUseCase, itemDetailUseCase, Dispatchers.IO)

    }

    @Test
    fun setDetailItem_withValidItem_updatesObjects() = runBlocking {
        // given
        val itemId = "ITEM-ID"
        val itemEntity = ItemEntity(id = itemId)
        sut.itemDetail.observeForever(itemObserver)
        given(scoreUseCase.run(anyString())).willReturn(Either.Right(ScoreEntity()))
        // when
        sut.setDetailItem(itemEntity)
        // then
        verify(itemObserver).onChanged(itemEntity)
    }
}