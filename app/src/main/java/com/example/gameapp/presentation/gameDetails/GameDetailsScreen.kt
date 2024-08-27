package com.example.gameapp.presentation.gameDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gameapp.R
import com.example.gameapp.data.remote.dto.GamesItem
import com.example.gameapp.presentation.gameDetails.componenets.DescriptionSection

@Composable
fun GameDetailsScreen(
    topAppBar:@Composable ()->Unit,
    game: GamesItem,
    viewModel: GameDetailViewModel = hiltViewModel()
)
{
    Scaffold(
        modifier = Modifier,
        topBar = {
            topAppBar()
        },
        content = { innerPadding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.background),

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
                            .aspectRatio(1.2f)
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

                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .height(500.dp)
                        .background(MaterialTheme.colorScheme.tertiary, shape = RoundedCornerShape(10.dp))
                        .align(Alignment.BottomCenter),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left
                )
                {
                    // The description section, potentially including a background to enhance readability
                    DescriptionSection(gamesItem = game, viewModel = viewModel)
                }

            }
        }
    )
}







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
