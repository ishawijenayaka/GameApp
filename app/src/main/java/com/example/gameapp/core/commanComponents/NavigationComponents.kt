package com.example.gameapp.core.commanComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun TopBarTitle(titleId: Int, hasBackButton: Boolean) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(end = if (hasBackButton) 50.dp else 0.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = titleId),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    titleId: Int,
    navController: NavController
) {
    fun navigateBack() {
        navController.navigateUp()
    }

    CenterAlignedTopAppBar(
        title = { TopBarTitle(titleId, navController.previousBackStackEntry != null) },
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                println("Navigation there is a previous screen")
                androidx.compose.material3.IconButton(onClick = {
                    navigateBack()
                }
                )
                {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.secondary,
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            navigationIconContentColor = MaterialTheme.colorScheme.secondary
        )
    )
}
