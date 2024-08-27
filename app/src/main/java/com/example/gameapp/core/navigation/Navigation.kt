package com.example.gameapp.core.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gameapp.core.commanComponents.AppTopAppBar
import com.example.gameapp.core.commanComponents.GeneralText
import com.example.gameapp.core.commanComponents.MyIcon
import com.example.gameapp.data.remote.dto.GamesItem
import com.example.gameapp.presentation.gameDetails.GameDetailsScreen
import com.example.gameapp.presentation.games.GameListScreen
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import kotlin.text.Charsets.UTF_8

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Navigation(){
    val navController = rememberNavController()
    var screenTitleId by remember { mutableIntStateOf(Screen.Games.resourceId) }

    // main navigation items
    val items = listOf (Screen.Games,)

    Scaffold(
        bottomBar = {
//            NavigationBar(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
//                containerColor = MaterialTheme.colorScheme.surface
//
//            )
//            {
//                val navBackStackEntry by navController.currentBackStackEntryAsState()
//                val currentDestination = navBackStackEntry?.destination
//
//                items.forEachIndexed { _, screen ->
//                    val selected = currentDestination?.hierarchy?.any { it.route == screen.route }
//
//                    NavigationBarItem(
//                        modifier = Modifier
//                            .padding()
//                            .weight(1f),
//                        icon = {
//                            if (selected == true) {
//                                MyIcon(
//                                    screen = screen ,
//                                    iconColor = MaterialTheme.colorScheme.primary
//                                )
//
//                            } else {
//                               MyIcon(
//                                   screen = screen ,
//                                   iconColor = MaterialTheme.colorScheme.secondary
//                               )
//                            }
//                        },
//                        label = {
//                            if (selected == true) {
//                                GeneralText(
//                                    title = stringResource(screen.resourceId),
//                                    align = TextAlign.Center,
//                                    textColor = MaterialTheme.colorScheme.primary
//                                )
//                            } else {
//                                GeneralText(
//                                    title = stringResource(screen.resourceId),
//                                    align = TextAlign.Center,
//                                    textColor = MaterialTheme.colorScheme.secondary
//                                )
//                            }
//                        },
//                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
//                        onClick = {
//                            screenTitleId = screen.resourceId
//                            navController.navigate(screen.route) {
//                                popUpTo(navController.graph.findStartDestination().id) {
//                                    saveState = true
//                                }
//                                launchSingleTop = true
//                                restoreState = true
//                            }
//                        },
//                        colors = NavigationBarItemDefaults
//                            .colors(
//                                indicatorColor = MaterialTheme.colorScheme.background)
//                    )
//                }
//            }
        }
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
//                val gameJson = backStackEntry.arguments?.getString("gameJson") ?: ""
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
