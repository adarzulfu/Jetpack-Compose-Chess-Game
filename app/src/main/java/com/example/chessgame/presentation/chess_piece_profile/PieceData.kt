package com.example.chessgame.presentation.chess_piece_profile

import androidx.annotation.DrawableRes
import com.example.chessgame.R


data class PieceData(@DrawableRes val image: Int, val name: String, val description: String)

val pieceListData = listOf(
  PieceData(image = R.drawable.ic_white_crown_king, name = "King", description = "Most important chess piece"),
  PieceData(image = R.drawable.ic_white_crown_queen, name = "Queen", description = "Moves vertically, horizontally, or diagonally"),
  PieceData(image = R.drawable.ic_white_rook, name = "Rook", description = "Moves vertically and horizontally"),
  PieceData(image = R.drawable.ic_white_bishop, name = "Bishop", description = "Moves diagonally"),
  PieceData(image = R.drawable.ic_white_knight, name = "Knight", description = "Moves in shape of L"),
  PieceData(image = R.drawable.ic_white_pawn, name = "Pawn", description = "Moves one or two steps")
)