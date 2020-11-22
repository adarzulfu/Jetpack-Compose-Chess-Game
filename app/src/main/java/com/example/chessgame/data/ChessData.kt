package com.example.chessgame.data

import androidx.annotation.DrawableRes
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

    WhiteQueen(R.drawable.ic_white_crown_queen),
    BlackQueen(R.drawable.ic_crown_queen),

    WhiteKing(R.drawable.ic_white_crown_king),
    BlackKing(R.drawable.ic_crown_king)
}
 fun createInitialSquares(): ArrayList<BoardMember> {
    val items = ArrayList<BoardMember>()
    val columnCount = 8
    for (i in 0..63) {

        val currentRow = i / columnCount
        if (currentRow == 1) {
            items.add(BoardMember(ChessPiece.BlackPawn))
        } else if (currentRow == 6) {
            items.add(BoardMember(ChessPiece.WhitePawn))
        } else if (i == 0 || i == 7) {
            items.add(BoardMember(ChessPiece.BlackRook))
        } else if (i == 56 || i == 63) {
            items.add(BoardMember(ChessPiece.WhiteRook))
        } else if (i == 1 || i == 6) {
            items.add(BoardMember(ChessPiece.BlackKnight))
        } else if (i == 57 || i == 62) {
            items.add(BoardMember(ChessPiece.WhiteKnight))
        } else if (i == 2 || i == 5) {
            items.add(BoardMember(ChessPiece.BlackBishop))
        } else if (i == 58 || i == 61) {
            items.add(BoardMember(ChessPiece.WhiteBishop))
        } else if (i == 3) {
            items.add(BoardMember(ChessPiece.BlackQueen))
        } else if (i == 59) {
            items.add(BoardMember(ChessPiece.WhiteQueen))
        } else if (i == 4) {
            items.add(BoardMember(ChessPiece.BlackKing))
        } else if (i == 60) {
            items.add(BoardMember(ChessPiece.WhiteKing))
        } else {
            items.add(BoardMember(null))
        }
    }
    return items
}
