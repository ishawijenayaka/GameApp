package com.example.gameapp.presentation.games

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameapp.core.Resource
import com.example.gameapp.domain.use_case.GetGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameListViewModel @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase
) : ViewModel() {

    val _state = mutableStateOf(GameListState())
    val state: State<GameListState> = _state

    init {
        getGames()
    }

    fun getGames() {
        viewModelScope.launch {
            getGamesUseCase().collect { result ->
                when (result) {
                    is Resource.Success<*> -> {
                        _state.value = GameListState(games = result.data)
                    }

                    is Resource.Error<*> -> {
                        _state.value = GameListState(
                            error = result.message ?: "An unexpected error occured"
                        )
                    }

                    is Resource.Loading<*> -> {
                        _state.value = GameListState(isLoading = true)
                    }
                }
            }
        }
    }
}