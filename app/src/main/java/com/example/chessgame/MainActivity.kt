package com.example.chessgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.example.chessgame.ui.ChessBoard
import androidx.activity.viewModels
import com.example.chessgame.data.ChessViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ChessViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChessBoard(viewModel)
        }
        viewModel.initSquarePeaces()
    }
}

