package com.example.gameapp.presentation.games

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.gameapp.core.Resource
import com.example.gameapp.data.remote.dto.GamesItem
import com.example.gameapp.domain.use_case.GetGamesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import kotlinx.coroutines.test.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.mockito.Mockito.`when`


class GameListViewModelTest{

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getGamesUseCase: GetGamesUseCase

    private lateinit var viewModel: GameListViewModel
    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {

        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        `when`(getGamesUseCase.invoke()).thenReturn(flowOf(Resource.Loading(), Resource.Success(listOf(GamesItem(id = 1, title = "Test Game")))))  // Properly return a Flow
        viewModel = GameListViewModel(getGamesUseCase)

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getGames loading state`() = runTest {
        `when`(getGamesUseCase()).thenReturn(flowOf(Resource.Loading()))
        viewModel.getGames()
        assertEquals(true, viewModel.state.value.isLoading)
        viewModel.state.value.games?.let { assertTrue(it.isEmpty()) }
        assertTrue(viewModel.state.value.errorMessage.isEmpty())
    }

    @Test
    fun `getGames success games`() = runTest {
        val games = listOf(GamesItem(id = 1, title = "Test Game",))
        `when`(getGamesUseCase()).thenReturn(flowOf(Resource.Success(games)))

        viewModel.getGames()
        assertEquals(games, viewModel.state.value.games)
        assertEquals(false, viewModel.state.value.isLoading)
        assertEquals("", viewModel.state.value.errorMessage)
    }


    @Test
    fun `getGames error`() = runTest {
        val errorMessage = "Network error"
        `when`(getGamesUseCase()).thenReturn(flowOf(Resource.Error(errorMessage)))

        viewModel.getGames()
        assertEquals(errorMessage, viewModel.state.value.errorMessage)
        viewModel.state.value.games?.let { assertTrue(it.isEmpty()) }
        assertEquals(false, viewModel.state.value.isLoading)
    }

}