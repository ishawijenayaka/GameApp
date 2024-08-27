package com.example.gameapp.core

import androidx.annotation.StringRes
import com.example.gameapp.R


sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
//    val iconActive: ImageVector,

)
{
    data object Games : Screen(
        "games",
        R.string.nav_game,
//        Icons.Default.Home,

    )

    data object GameDetails : Screen(
        "gameDetails/{gameJson}",
        R.string.nav_game_details,
//        Icons.Default.Favorite,
    )

}