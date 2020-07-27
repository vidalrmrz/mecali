package com.vr.domain.usecases

import com.nhaarman.mockitokotlin2.given
import com.vr.domain.base.Either
import com.vr.domain.base.Failure
import com.vr.domain.entities.ItemEntity
import com.vr.domain.repositories.SearchRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchUseCaseTest {

    @Mock
    lateinit var searchRepository: SearchRepository

    private lateinit var sut: SearchUseCase
    private val invalidQuery = "Q"
    private val validQuery = "S20 +"

    @Before
    fun setup() {
        sut = SearchUseCase(searchRepository)
    }

    @Test
    fun runWithValidQuery_success_returnsList() {
        val itemResult = Either.Right(listOf<ItemEntity>())
        // given
        runBlocking {
            given(searchRepository.search(anyString()))
                .willReturn(itemResult)

            // when
            val result = sut.run(validQuery)

            // then
            assertEquals(itemResult, result)
            assertTrue(result.isRight)
        }
    }

    @Test
    fun runWithValidQuery_failure_returnsFailure() {
        val itemResult = Either.Left(Failure.analyzeException(Exception()))
        // given
        runBlocking {
            given(searchRepository.search(anyString()))
                .willReturn(itemResult)

            // when
            val result = sut.run(validQuery)

            // then
            assertEquals(itemResult, result)
            assertTrue(result.isLeft)
        }
    }

    @Test
    fun runWithInvalidQuery_success_returnsEmpty() {
        val itemResult = Either.Right(listOf(ItemEntity(), ItemEntity()))
        // given
        runBlocking {
            given(searchRepository.search(anyString()))
                .willReturn(itemResult)

            // when
            val result = sut.run(invalidQuery)

            // then
            result.fold({}, { assertTrue(it.isEmpty()) })
            assertTrue(result.isRight)
        }
    }

    @Test
    fun runWithInvalidQuery_failure_returnsEmpty() {
        val itemResult = Either.Left(Failure.analyzeException(Exception()))
        // given
        runBlocking {
            given(searchRepository.search(anyString()))
                .willReturn(itemResult)

            // when
            val result = sut.run(invalidQuery)

            // then
            result.fold({}, { assertTrue(it.isEmpty()) })
            assertTrue(result.isRight)
        }
    }
}