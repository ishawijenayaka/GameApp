package com.example.gameapp.data.remote.dto

import com.google.gson.Gson
import org.junit.Assert.*
import org.junit.Test

class GamesItemTest{

    private val gson = Gson()

    @Test
    fun `test serialization of GamesItem`() {
        val game = GamesItem(
            id = 1,
            developer = "Developer Name",
            gameProfileUrl = "https://example.com/profile",
            gameUrl = "https://example.com/game",
            genre = "Action",
            platform = "PC",
            publisher = "Publisher Name",
            releaseDate = "2021-01-01",
            shortDescription = "A short description of the game.",
            thumbnail = "https://example.com/thumbnail.jpg",
            title = "Game Title"
        )

        val json = gson.toJson(game)
        assertTrue(json.contains("\"game_url\":\"https://example.com/game\""))
        assertTrue(json.contains("\"freetogame_profile_url\":\"https://example.com/profile\""))
        assertTrue(json.contains("\"developer\":\"Developer Name\""))
    }

    @Test
    fun `test deserialization of GamesItem`() {
        val json = """
            {
                "id": 1,
                "developer": "Developer Name",
                "freetogame_profile_url": "https://example.com/profileurl",
                "game_url": "https://example.com/gameurl",
                "genre": "Action",
                "platform": "PC",
                "publisher": "Publisher Name",
                "release_date": "2021-01-01",
                "short_description": "A short description of the game.",
                "thumbnail": "https://example.com/thumbnail.jpg",
                "title": "Game Title"
            }
        """.trimIndent()

        val game = gson.fromJson(json, GamesItem::class.java)
        assertNotNull(game)
        assertEquals(1, game.id)
        assertEquals("Developer Name", game.developer)
        assertEquals("https://example.com/profileurl", game.gameProfileUrl)
        assertEquals("https://example.com/gameurl", game.gameUrl)
        assertEquals("Action", game.genre)
        assertEquals("PC", game.platform)
        assertEquals("Publisher Name", game.publisher)
        assertEquals("2021-01-01", game.releaseDate)
        assertEquals("A short description of the game.", game.shortDescription)
        assertEquals("https://example.com/thumbnail.jpg", game.thumbnail)
        assertEquals("Game Title", game.title)
    }
}