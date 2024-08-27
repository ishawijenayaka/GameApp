package com.example.gameapp.presentation.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gameapp.core.Screen
import com.example.gameapp.core.commanComponents.AppTopAppBar
import com.example.gameapp.data.remote.dto.GamesItem
import com.example.gameapp.presentation.gameDetails.GameDetailsScreen
import com.example.gameapp.presentation.games.GameListScreen
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import kotlin.text.Charsets.UTF_8


@Composable
fun Navigation(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { }
    )
    { innerPadding ->

        val startDestination = Screen.Games.route

        NavHost(
            navController,
            startDestination = startDestination,
        )
        {
            composable(Screen.Games.route) {
                GameListScreen(
                    topAppBar = {
                        AppTopAppBar(
                            titleId = Screen.Games.resourceId,
                            navController = navController
                        )
                    },
                    navController = navController,
                )
            }

            composable(Screen.GameDetails.route) { backStackEntry ->
                //to decode object
                val gameJson = URLDecoder.decode(backStackEntry.arguments?.getString("gameJson") ?: "", UTF_8.toString())
                val game = Json.decodeFromString<GamesItem>(gameJson)

                GameDetailsScreen(
                    topAppBar = {
                        AppTopAppBar(
                            titleId = Screen.GameDetails.resourceId,
                            navController = navController
                        )
                    },
                   game = game
                )
            }
        }
    }
}
