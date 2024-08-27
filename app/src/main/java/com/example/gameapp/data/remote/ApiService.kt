package com.example.apptask.data.remote

import com.example.gameapp.data.remote.dto.GamesItem
import retrofit2.http.GET

interface ApiService {

    @GET("api/games")
    suspend fun getAllGames(): List<GamesItem>
}