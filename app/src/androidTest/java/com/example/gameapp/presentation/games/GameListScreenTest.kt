package com.example.gameapp.presentation.games


import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gameapp.MainActivity
import com.example.gameapp.presentation.navigation.Navigation
import com.example.gameapp.data.remote.dto.GamesItem
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.net.URLEncoder



//@RunWith(AndroidJUnit4::class)
//@HiltAndroidTest
//class GameListScreenTest{
//
//    @get:Rule
//    val composeTestRule = createAndroidComposeRule<MainActivity>()
//    private lateinit var navController: TestNavHostController
//
//    @Before
//    fun setupNavHost() {
//        composeTestRule.setContent {
//            navController = TestNavHostController(LocalContext.current)
//            navController.navigatorProvider.addNavigator(ComposeNavigator())
//            Navigation()
//        }
//    }
//
//    @Test
//    fun itemClick_navigatesToDetailScreen(){
//        composeTestRule.onNodeWithText("Test Game")
//            .performClick()
//
//        val fakeGames = listOf(GamesItem(id = 1, title = "Test Game"))
//        val gameJson = Json.encodeToString(fakeGames.first())
//        val encodedGameJson = URLEncoder.encode(gameJson, "UTF-8")
//        val route = navController.currentBackStackEntry?.destination?.route
//        assertEquals(route, "gameDetails/$encodedGameJson")
//    }
//
////    @Test
////    fun gameItem_clickNavigatesToDetails() {
////
////        // Prepare the JSON string as expected in the application.
////        val fakeGames = listOf(GamesItem(id = 1, title = "Test Game"))
////        val gameJson = Json.encodeToString(fakeGames.first())
////        val encodedGameJson = URLEncoder.encode(gameJson, "UTF-8")
////        val expectedNavDestination = "gameDetails/$encodedGameJson"
////
////        // Perform click on the item that should navigate to details
////        composeTestRule.onNodeWithText("Test Game", useUnmergedTree = true).performClick()
////
////        // Check if navigation was triggered correctly
////        assertEquals(expectedNavDestination, navHostController.currentBackStackEntry?.destination?.route)
////    }
//
////        val fakeGames = listOf(GamesItem(id = 1, title = "Test Game"))
////        val gameJson = Json.encodeToString(fakeGames.first())
////        val encodedGameJson = URLEncoder.encode(gameJson, "UTF-8")
////        val expectedNavDestination = "gameDetails/$encodedGameJson"
////
////        // Perform click on the item that should navigate to details
////        composeTestRule.onNodeWithText("Test Game").performClick()
////
////        // Check if navigation was triggered correctly
////        assert(navHostController.currentBackStackEntry?.destination?.route == expectedNavDestination)
////    }
//}




