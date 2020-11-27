package com.example.chessgame.presentation.hello_world

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun HelloWorld2() {
    Row {
        Text("Hello World")
        Text("How are you?")
    }
}