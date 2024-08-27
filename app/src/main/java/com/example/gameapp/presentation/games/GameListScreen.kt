package com.example.gameapp.presentation.games

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gameapp.core.commanComponents.MainTitle
import com.example.gameapp.data.remote.dto.GamesItem
import com.example.gameapp.core.commanComponents.ProgressView
import com.example.gameapp.presentation.games.components.GameListItem
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun GameListScreen(
    topAppBar:@Composable ()->Unit,
    navController: NavController,
    viewModel: GameListViewModel = hiltViewModel()
){

    Scaffold(
        modifier = Modifier,
        topBar = {
            topAppBar()
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(top = innerPadding.calculateTopPadding(), bottom = innerPadding.calculateBottomPadding())
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
            )
            {
                if (viewModel.state.value.isLoading) {
                    ProgressView(modifier = Modifier)
                }

                val games = viewModel.state.value.games
                if (games.isNullOrEmpty()) {
                    Text("No games available",
                        modifier = Modifier
                    )
                } else {

                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        items(games){ game ->
                            GameListItem(
                                game = game,
                                modifier = Modifier,
                                onClick = {
                                    val gameJson = Json.encodeToString(game)
//                                    val gameJson =  Json.encodeToString(GamesItem.serializer(), game)
                                    val encodedGameJson = URLEncoder.encode(gameJson, "UTF-8")
                                    navController.navigate("gameDetails/$encodedGameJson")
                                }
                            )
                        }
                    }
                }
            }
        }
    )
}