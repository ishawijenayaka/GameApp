package com.example.gameapp.presentation.gameDetails.componenets

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gameapp.R
import com.example.gameapp.core.commanComponents.GeneralText
import com.example.gameapp.core.commanComponents.MainTitle
import com.example.gameapp.core.commanComponents.RoundedCornerButton
import com.example.gameapp.core.commanComponents.SectionTitle
import com.example.gameapp.core.commanComponents.SubText
import com.example.gameapp.data.remote.dto.GamesItem

@Composable
fun DescriptionSection(gamesItem: GamesItem) {

    val loaded = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val openUrlLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ){}

    LaunchedEffect(key1 = "") {
        loaded.value = true
    }

    // Define the enter transition
    val enterTransition = slideInHorizontally(
        initialOffsetX = { fullWidth -> -fullWidth }, // Slide in from the left
        animationSpec = tween(durationMillis = 600)
    ) + fadeIn(animationSpec = tween(durationMillis = 600))

    // Define the exit transition
    val exitTransition = slideOutHorizontally(
        targetOffsetX = { fullWidth -> fullWidth }, // Slide out to the right
        animationSpec = tween(durationMillis = 600)
    ) + fadeOut(animationSpec = tween(durationMillis = 600))

    AnimatedVisibility(
        visible = loaded.value,
        enter = enterTransition,
        exit = exitTransition
    )
    {

        Column(
            modifier = Modifier
                .padding(15.dp)
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Top,

        )
        {

//            MainTitle(
//                modifier = Modifier,
//                title = gamesItem.title,
//                align = TextAlign.Center
//            )

            GeneralText(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 5.dp),
                title = gamesItem.shortDescription,
                align = TextAlign.Justify,
                maxLines = 10
            )

            SubText(
                modifier = Modifier,
                title = context.getString(R.string.published_by, gamesItem.publisher),
                align = TextAlign.End
            )

            SectionTitle(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 5.dp),
                title = "More Info : " ,
                align = TextAlign.Start
            )

            GeneralText(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp),
                title = context.getString(R.string.works_for, gamesItem.platform),
                align = TextAlign.Start,
                maxLines = 10
            )

            GeneralText(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp),
                title = context.getString(R.string.genre,gamesItem.genre),
                align = TextAlign.Start,
                maxLines = 10
            )

            GeneralText(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp),
                title = context.getString(R.string.released_date,gamesItem.releaseDate),
                align = TextAlign.Start,
                maxLines = 10
            )

            GeneralText(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp),
                title = context.getString(R.string.developed_by,gamesItem.developer),
                align = TextAlign.Start,
                maxLines = 10
            )

            GeneralText(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(gamesItem.gameUrl))
                        openUrlLauncher.launch(intent)
                    },
                title = context.getString(R.string.game_url,gamesItem.gameUrl),
                align = TextAlign.Start,
                maxLines = 10
            )

            GeneralText(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp),
                title = context.getString(R.string.free_game_profile_url, gamesItem.gameProfileUrl),
                align = TextAlign.Start,
                maxLines = 10
            )

            Spacer(modifier = Modifier.height(50.dp))

        }
    }
}