package com.example.gameapp.core.commanComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ErrorAlertBox(
    onDismiss: () -> Unit,
    title: String,
    text : String,
    isShow: Boolean
) {

    if (isShow) {

        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = text,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 14.sp
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        onDismiss()
                    }
                )
                {
                    Text("OK")
                }
            },
            containerColor = MaterialTheme.colorScheme.background
        )
    }
}


@Composable
fun ErrorSnackBar(errorMsg: String, isShow: Boolean) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 5.dp)
        ) {


            if (isShow) {
                Snackbar(modifier = Modifier, containerColor = Color.White,
                    action = {}) {
                    Text(text = errorMsg, fontSize = 16.sp, color = Color.Red)
                }
            }
        }
    }
}
