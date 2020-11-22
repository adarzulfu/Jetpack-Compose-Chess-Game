package com.example.chessgame.presentation.chess_game


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Layout
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import kotlin.math.ceil
import androidx.compose.ui.graphics.Color
import androidx.ui.tooling.preview.Preview

import com.example.chessgame.ui.chessBlack
import com.example.chessgame.ui.chessWhite

const val CHESS_BOARD_SIZE = 64
const val COLUMN_COUNT = 8

@Composable
fun ChessBoardPlacer(
  modifier: Modifier,
  columnCount: Int = 8,
  composable: @Composable () -> Unit
) {

    Layout(modifier = modifier, children = composable) { measures, constraints ->
        val eachItemSize = constraints.maxWidth / columnCount
        val rowCount = ceil((measures.count() / columnCount).toFloat()).toInt()

        val layoutHeight = eachItemSize * rowCount

        val placeables = measures.map {
            it.measure(Constraints.fixed(eachItemSize, eachItemSize))
        }


        layout(height = layoutHeight, width = constraints.maxWidth) {

            var (xPosition, yPosition) = 0

            placeables.forEachIndexed { index, placeable ->

                placeable.placeRelative(x = xPosition, y = yPosition)
                xPosition += placeable.width

                if ((index + 1) % columnCount == 0) {
                    yPosition += placeable.height
                    xPosition = 0
                }
            }
        }
    }

}

@Composable
fun ChessBoard(viewModel: ChessViewModel) {
    val list = viewModel.squareList
    if (list.isNotEmpty()) {
        ChessBoardPlacer(modifier = Modifier.fillMaxWidth().border(3.dp, Color.Black)) {
            for (i in list.indices) {
                val boardMember = list[i]
                BoardSquare(backgroundColor = getBoxColor(i, boardMember.isSelected),
                  boardMember = boardMember,
                  onClick = viewModel::onSquareSelected
                )
            }
        }
    }
}

@Composable
fun BoardSquare(modifier: Modifier = Modifier,
                backgroundColor: Color,
                boardMember: BoardMember,
                onClick: (item: BoardMember) -> Unit) {

    Box(
      modifier = modifier
        .background(backgroundColor)
        .clickable(onClick = { onClick.invoke(boardMember) }),
      alignment = Alignment.Center
    ) {
        boardMember.chessPiece?.let {
            Image(
              asset = vectorResource(id = it.id),
              modifier = Modifier.padding(
                start = 4.dp,
                top = 4.dp,
                end = 4.dp
              )
            )
        }
    }

}

@Preview
@Composable
fun BoardSquarePreview() {
    BoardSquare(modifier = Modifier.size(50.dp),
      backgroundColor = Color.Green,
      boardMember = BoardMember(),
      onClick = {}
    )
}

fun getBoxColor(currentPosition: Int, isSelected: Boolean): Color {
    val currentRow = currentPosition / COLUMN_COUNT
    return when {
        isSelected -> {
            Color.Green
        }
        (currentPosition + currentRow) % 2 == 0 -> {
            chessWhite
        }
        else -> {
            chessBlack
        }
    }
}

