package com.example.gameapp.core.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.gameapp.R


sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val iconActive: ImageVector,

)
{
    data object Games : Screen(
        "games",
        R.string.nav_game,
        Icons.Default.Home,

    )

    data object GameDetails : Screen(
        "gameDetails/{gameJson}",
        R.string.nav_game_details,
        Icons.Default.Favorite,
    )

}