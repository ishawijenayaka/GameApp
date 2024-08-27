package com.example.gameapp.presentation.gameDetails

import android.content.Context

sealed class GameDetailEvent {
    data class OpenUrl(val url: String, val context: Context) : GameDetailEvent()
}