package com.example.gameapp.domain.repository

import com.example.gameapp.data.remote.dto.GamesItem


interface GameRepository {

    suspend fun getGames(): List<GamesItem>
}