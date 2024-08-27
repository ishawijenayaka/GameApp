package com.example.gameapp.data.remote.repository

import com.example.apptask.data.remote.ApiService
import com.example.gameapp.data.remote.dto.GamesItem
import com.example.gameapp.data.repository.GamesRepositoryImpl
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GamesRepositoryImplTest {

    @Mock
    private lateinit var apiService: ApiService
    private lateinit var gamesRepositoryImpl: GamesRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        gamesRepositoryImpl = GamesRepositoryImpl(apiService)
    }


    @Test
    fun `getGames calls api and returns games`() = runTest {
        val expectedGames = listOf(GamesItem())
        `when`(apiService.getAllGames()).thenReturn(expectedGames)

        val games = gamesRepositoryImpl.getGames()

        verify(apiService).getAllGames()
        assertEquals(expectedGames, games)
    }
}