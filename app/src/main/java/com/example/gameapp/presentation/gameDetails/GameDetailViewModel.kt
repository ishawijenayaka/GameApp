package com.example.gameapp.presentation.gameDetails

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(): ViewModel() {

    fun onEvent(events: GameDetailEvent) {
        when (events) {
            is GameDetailEvent.OpenUrl -> {
                openUrl(events.url, events.context)
            }
        }
    }

    private fun openUrl(url: String, context: Context) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

}