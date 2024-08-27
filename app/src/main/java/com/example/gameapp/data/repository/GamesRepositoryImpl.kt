package com.example.gameapp.data.repository

import com.example.apptask.data.remote.ApiService
import com.example.gameapp.data.remote.dto.GamesItem
import com.example.gameapp.domain.repository.GameRepository
import javax.inject.Inject


class GamesRepositoryImpl @Inject constructor(
    private val api: ApiService
) : GameRepository {

    override suspend fun getGames(): List<GamesItem> {
       return api.getAllGames()
    }

}