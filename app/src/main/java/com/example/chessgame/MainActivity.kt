package com.example.chessgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.setContent
import com.example.chessgame.ui.ChessBoard
import com.example.chessgame.ui.ChessGameTheme
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.chessgame.data.ChessViewModel
import com.example.chessgame.ui.chessBlack

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<ChessViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChessBoard(viewModel = viewModel)
        }
        viewModel.initSquarePeaces()
    }
}

@Composable
fun PawnProfile() {
    val borderColor = remember { randomColor() }
    Row(modifier = Modifier.background(MaterialTheme.colors.surface)
            .padding(8.dp)) {
        Image(
                asset = vectorResource(id = R.drawable.ic_white_pawn),
                modifier = Modifier
                        .border(2.dp, borderColor, CircleShape)
                        .padding(4.dp)
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(chessBlack)
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
        )

        Column(
                modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
        ) {
            Text(
                    text = "Pawn",
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic
            )
            Text(
                    text = "Moves one or two steps",
                    fontFamily = FontFamily.Serif,
                    color = Color.Gray
            )
        }
    }
}


@Preview
@Composable
fun PawnProfilePreview() {
    ChessGameTheme(false) {
        PawnProfile()
    }
}

fun randomColor(): Color {
    val colors = arrayOf(Color.Black, Color.Yellow, Color.Green)
    val randomIndex = (0..2).shuffled().first()
    return colors[randomIndex]
}