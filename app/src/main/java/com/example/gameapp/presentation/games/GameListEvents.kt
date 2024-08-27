package com.example.gameapp.presentation.games

sealed class GameListEvents {
    data object ResetError : GameListEvents()
}
