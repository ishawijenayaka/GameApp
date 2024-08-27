package com.example.gameapp.presentation.games

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gameapp.R
import com.example.gameapp.core.commanComponents.ErrorSnackBar
import com.example.gameapp.core.commanComponents.GeneralText
import com.example.gameapp.core.commanComponents.ProgressView
import com.example.gameapp.presentation.games.components.GameListItem
import kotlinx.coroutines.delay
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLEncoder

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
                    .padding(
                        top = innerPadding.calculateTopPadding(),
                        bottom = innerPadding.calculateBottomPadding()
                    )
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
            )
            {
                if (viewModel.state.value.isLoading) {
                    ProgressView(modifier = Modifier)
                }

                val games = viewModel.state.value.games
                if (games.isNullOrEmpty()) {

                    GeneralText(
                        modifier = Modifier
                            .padding(25.dp),
                        title = stringResource(id = R.string.empty_game_list)
                    )

                } else {
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        items(games){ game ->
                            GameListItem(
                                game = game,
                                modifier = Modifier,
                                onClick = {
                                    val gameJson = Json.encodeToString(game)
                                    val encodedGameJson = URLEncoder.encode(gameJson, "UTF-8")
                                    navController.navigate("gameDetails/$encodedGameJson")
                                }
                            )
                        }
                    }
                }

                ErrorSnackBar(
                    errorMsg = viewModel.state.value.errorMessage ?: "",
                    isShow = viewModel.state.value.isShowError
                )

                if (viewModel.state.value.isShowError) {
                    LaunchedEffect(key1 = viewModel.state.value.isShowError) {
                        delay(2000)
                        viewModel.onEvent(GameListEvents.ResetError)
                    }
                }
            }
        }
    )
}