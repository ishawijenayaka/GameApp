package com.example.gameapp.presentation.games.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gameapp.R
import com.example.gameapp.core.commanComponents.GeneralText
import com.example.gameapp.data.remote.dto.GamesItem

@Composable
fun GameListItem(
    game: GamesItem,
    onClick: (GamesItem) -> Unit,
    modifier : Modifier
){

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable {
                onClick(game)
            }
    )
    {

        Box {
            if (game.thumbnail.isNotEmpty()) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(game.thumbnail)
                        .crossfade(500)
                        .error(R.drawable.default_image)
                        .build(),
                    contentDescription = "game Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()

                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.default_image),
                    contentDescription = game.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    alignment = Alignment.Center
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.Black.copy(alpha = 0.7f))
                    .align(Alignment.BottomCenter),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.Left
            )
            {
                GeneralText(
                    modifier = Modifier
                        .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                    title = game.title.uppercase(),
                    textColor = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    align = TextAlign.Center
                )
            }
        }
//        Row(
//            horizontalArrangement = Arrangement.Start,
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(150.dp)
//                .padding(10.dp)
//        )
//        {
//            if (game.thumbnail.isNotEmpty()) {
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(game.thumbnail)
//                        .fallback(com.example.gameapp.R.drawable.default_image)
//                        .error(com.example.gameapp.R.drawable.default_image)
//                        .crossfade(true)
//                        .build(),
//                    contentDescription = game.title,
//                    modifier = Modifier
//                        .fillMaxHeight()
//                        .clip(RoundedCornerShape(10.dp)),
//                    alignment = Alignment.Center,
//                    error = painterResource(id = com.example.gameapp.R.drawable.default_image)
//                )
//            } else {
//                Image(
//                    painter = painterResource(id = com.example.gameapp.R.drawable.default_image),
//                    contentDescription = game.title,
//                    modifier = Modifier
//                        .fillMaxHeight(),
//                    alignment = Alignment.Center
//                )
//            }
//
//            GeneralText(
//                modifier = Modifier
//                    .padding(start = 10.dp),
//                title = game.title
//            )
//
//        }
    }
}