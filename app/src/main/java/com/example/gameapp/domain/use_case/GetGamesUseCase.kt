package com.example.gameapp.domain.use_case

import com.example.gameapp.data.remote.dto.GamesItem
import com.example.gameapp.core.Resource
import com.example.gameapp.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val repository: GameRepository
) {
    operator fun invoke(): Flow<Resource<List<GamesItem>>> = flow {
        try {
            emit(Resource.Loading())
            val games = repository.getGames()
            emit(Resource.Success(games))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error(e.localizedMessage ?:"Couldn't reach server. Check your internet connection."))
        }
    }
}