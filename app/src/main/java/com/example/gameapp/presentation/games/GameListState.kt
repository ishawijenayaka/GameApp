package com.example.gameapp.presentation.games

import com.example.gameapp.data.remote.dto.GamesItem

data class GameListState(
    val isLoading: Boolean = false,
    val games: List<GamesItem> ? = emptyList(),
    val errorMessage: String = "",
    val isShowError: Boolean = false,
)