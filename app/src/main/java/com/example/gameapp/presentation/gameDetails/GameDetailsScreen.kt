package com.example.gameapp.presentation.gameDetails

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gameapp.R
import com.example.gameapp.data.remote.dto.GamesItem
import com.example.gameapp.presentation.gameDetails.componenets.DescriptionSection
import com.example.gameapp.presentation.gameDetails.componenets.GameDetailsUi
import java.net.URLDecoder

@Composable
fun GameDetailsScreen(
    topAppBar:@Composable ()->Unit,
    game: GamesItem,
)
{
    Scaffold(
        modifier = Modifier,
        topBar = {
            topAppBar()
        },
        content = { innerPadding ->

//            Box(modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//            ) {
//                // Background image
//                if (game.thumbnail.isNotEmpty()) {
//                    AsyncImage(
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(game.thumbnail)
//                            .crossfade(500)
//                            .error(R.drawable.default_image)
//                            .build(),
//                        contentDescription = "game Image",
//                        contentScale = ContentScale.FillBounds,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .fillMaxHeight(0.5f)
//                    )
//                } else {
//                    Image(
//                        painter = painterResource(id = R.drawable.default_image),
//                        contentDescription = game.title,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .fillMaxHeight(0.5f),
//                        contentScale = ContentScale.FillBounds
//                    )
//                }
//
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(
//                            brush = Brush.verticalGradient(
//                                colors = listOf(Color.Transparent, Color.Black),
//                                startY = 500f,  // Start further down to avoid harsh lines
//                                endY = 1000f    // End point set to ensure smooth transition
//                            )
//                        )
//
//                )
//                {
//
//                }
//
//                Box(
//                    modifier = Modifier
//                        .align(Alignment.BottomStart)
//                        .fillMaxWidth()
//                        .padding(start = 20.dp, end = 20.dp)
//                        .height(450.dp)  // Set a fixed height for the description area
//                )
//                {
////                    Column(
////                        modifier = Modifier
////                            .verticalScroll(rememberScrollState())
////                            .align(Alignment.BottomEnd)
////                            .padding(16.dp)
////                    ) {
//                        DescriptionSection(game)
////                    }
//                }
//
//                // Description section
//
//            }
//        }
//    )
//}

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Top,
            )
            {
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
                            .aspectRatio(1.5f)
                    )

                } else {
                    Image(
                        painter = painterResource(id = R.drawable.default_image),
                        contentDescription = game.title,
                        modifier = Modifier
                            .fillMaxHeight(),
                        alignment = Alignment.Center
                    )
                }

                DescriptionSection(gamesItem = game)

            }
        }
    )
}