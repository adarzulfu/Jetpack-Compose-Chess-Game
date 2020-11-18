package com.example.chessgame.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.vectorResource
import com.example.chessgame.R
import java.util.*

data class BoardMember(
        var chessPiece: ChessPiece? = null,
        var isSelected: Boolean = false,
        val id: UUID = UUID.randomUUID()
)

enum class ChessPiece(@DrawableRes val id: Int) {
    WhitePawn(R.drawable.ic_white_pawn),
    BlackPawn(R.drawable.ic_pawn),

    WhiteRook(R.drawable.ic_white_rook),
    BlackRook(R.drawable.ic_rook),

    WhiteKnight(R.drawable.ic_white_knight),
    BlackKnight(R.drawable.ic_knight),

    WhiteBishop(R.drawable.ic_white_bishop),
    BlackBishop(R.drawable.ic_bishop),

    WhiteQueen(R.drawable.ic_white_queen),
    BlackQueen(R.drawable.ic_queen),

    WhiteKing(R.drawable.ic_white_king),
    BlackKing(R.drawable.ic_king)
}
