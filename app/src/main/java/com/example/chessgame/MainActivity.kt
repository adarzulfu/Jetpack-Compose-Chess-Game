package com.example.chessgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.setContent
import com.example.chessgame.ui.ChessBoard
import com.example.chessgame.ui.ChessGameTheme
import androidx.activity.viewModels
import com.example.chessgame.data.ChessViewModel

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<ChessViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChessGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ChessBoard(viewModel)
                }
            }
        }
        viewModel.initSquarePeaces()
    }
}