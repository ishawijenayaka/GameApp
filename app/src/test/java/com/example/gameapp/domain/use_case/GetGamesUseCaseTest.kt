package com.example.gameapp.domain.use_case

import com.example.gameapp.core.Resource
import com.example.gameapp.data.remote.dto.GamesItem
import com.example.gameapp.domain.repository.GameRepository
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetGamesUseCaseTest {

    @Mock
    private lateinit var gameRepository: GameRepository

    private lateinit var getGamesUseCase: GetGamesUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getGamesUseCase = GetGamesUseCase(gameRepository)
    }

    @Test
    fun `invoke emits loading and then success`() = runTest {
        val gamesList = listOf(GamesItem())
        `when`(gameRepository.getGames()).thenReturn(gamesList)

        val result = getGamesUseCase().toList()

        // Test the Loading state potentially with no data
        assertTrue(result[0] is Resource.Loading && result[0].data == null)
        // Test the Success state with data
        assertTrue(result[1] is Resource.Success && result[1].data == gamesList)
    }

    @Test
    fun `invoke emits loading and then error on exception`() = runTest {
        val errorMessage = "An unexpected error occured"
        `when`(gameRepository.getGames()).thenThrow(RuntimeException(errorMessage))

        val result = getGamesUseCase().toList()

        // Check Loading state with no data
        assertTrue(result[0] is Resource.Loading && result[0].data == null)

        // Check Error state with correct message and potentially no data
        assertTrue(result[1] is Resource.Error)
        assertEquals((result[1] as Resource.Error).message, errorMessage)
        assertNull((result[1] as Resource.Error).data)
    }

}