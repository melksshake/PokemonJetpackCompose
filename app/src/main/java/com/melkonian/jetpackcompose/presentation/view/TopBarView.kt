package com.melkonian.jetpackcompose.presentation.view

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun TopBarView(title: String = "", buttonIcon: ImageVector, onButtonClicked: (() -> Unit)?) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            onButtonClicked?.let {
                IconButton(onClick = { it() }) {
                    Icon(buttonIcon, contentDescription = "")
                }
            }
        },
        backgroundColor = MaterialTheme.colors.primaryVariant
    )
}