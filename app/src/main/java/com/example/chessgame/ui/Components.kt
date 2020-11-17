package com.example.chessgame.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.chessgame.data.ChessViewModel
import kotlin.math.ceil
import androidx.compose.ui.graphics.Color

import com.example.chessgame.data.BoardMember

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
    ChessBoardPlacer(modifier = Modifier.fillMaxWidth()) {
        for (i in 0 until CHESS_BOARD_SIZE) {
            val boardMember = viewModel.squareList[i]
            if (viewModel.squareList.isNotEmpty()) {
                BoardSquare(backgroundColor = bringBoxColor(i, boardMember),
                        boardMember = boardMember,
                        onClick = viewModel::onSquareSelected
                )
            }
        }
    }
}

@Composable
fun BoardSquare(backgroundColor: Color, boardMember: BoardMember, onClick: (item: BoardMember) -> Unit) {
    var localBackgroundColor = backgroundColor

    Box(Modifier.background(localBackgroundColor).clickable(onClick = { onClick.invoke(boardMember) }), alignment = Alignment.Center) {
        boardMember.chessPiece?.let {
            Image(
                    vectorResource(id = it.id),
                    modifier = Modifier.padding(
                            start = 10.dp,
                            top = 10.dp,
                            end = 10.dp
                    )
            )
        }
    }
}

fun bringBoxColor(currentPosition: Int, boardMember: BoardMember): Color {
    val currentRow = currentPosition / COLUMN_COUNT
    return if (boardMember.chessPiece != null && boardMember.isSelected) {
        Color.Green
    } else if ((currentPosition + currentRow) % 2 == 0) {
        chessWhite
    } else {
        chessBlack
    }
}

