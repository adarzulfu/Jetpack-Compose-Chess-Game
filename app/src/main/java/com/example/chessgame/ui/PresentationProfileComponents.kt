package com.example.chessgame.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
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
import com.example.chessgame.R

@Composable
fun PawnProfile() {
    val borderColor = remember { randomColor() }
    Row(modifier = Modifier
      .background(MaterialTheme.colors.surface)
      .padding(8.dp)
    ) {
        Image(
          asset = vectorResource(id = R.drawable.ic_white_pawn),
          modifier = Modifier
            .border(2.dp, borderColor, CircleShape)
            .padding(4.dp)
            .clip(CircleShape)
            .size(48.dp)
            .background(chessBlack)
            .padding(8.dp)
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
    val colors = arrayOf(Color.Black, Color.Yellow, Color.Green, Color.Blue)
    val randomIndex = (0..2).shuffled().first()
    return colors[randomIndex]
}