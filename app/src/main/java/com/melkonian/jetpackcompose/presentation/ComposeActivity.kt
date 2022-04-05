package com.melkonian.jetpackcompose.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun MainScreen() {
        val textString = if (LocalInspectionMode.current) {
            "Hello preview user!"
        } else {
            "Hello YOU!"
        }
        Text(textString)
    }
}