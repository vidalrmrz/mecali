package com.vr.domain.usecases

import com.nhaarman.mockitokotlin2.given
import com.vr.domain.base.Either
import com.vr.domain.base.Failure
import com.vr.domain.entities.ItemDetailEntity
import com.vr.domain.entities.ScoreEntity
import com.vr.domain.repositories.SearchRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ScoreUseCaseTest {

    @Mock
    lateinit var searchRepository: SearchRepository

    private lateinit var sut: ScoreUseCase

    @Before
    fun setup() {
        sut = ScoreUseCase(searchRepository)
    }

    @Test
    fun run_success_returnsItemDetailEntity() {
        val itemId = "ITEM-ID"
        val itemResult = Either.Right(ScoreEntity())
        // given
        runBlocking {
            given(searchRepository.review(ArgumentMatchers.anyString()))
                .willReturn(itemResult)

            // when
            val result = sut.run(itemId)

            // then
            Assert.assertEquals(itemResult, result)
            Assert.assertTrue(result.isRight)
        }
    }

    @Test
    fun run_failure_returnsFailure() {
        val itemId = "ITEM-ID"
        val itemResult = Either.Left(Failure.analyzeException(Exception()))
        // given
        runBlocking {
            given(searchRepository.review(ArgumentMatchers.anyString()))
                .willReturn(itemResult)

            // when
            val result = sut.run(itemId)

            // then
            Assert.assertEquals(itemResult, result)
            Assert.assertTrue(result.isLeft)
        }
    }
}