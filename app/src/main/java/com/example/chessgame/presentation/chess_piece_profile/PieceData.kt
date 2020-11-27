package com.example.chessgame.presentation.chess_piece_profile

import androidx.annotation.DrawableRes
import com.example.chessgame.R


data class PieceData(@DrawableRes val image: Int, val name: String, val description: String)

val pieceListData = listOf(
  PieceData(image = R.drawable.ic_white_crown_king, name = "White King", description = "Most important chess piece"),
  PieceData(image = R.drawable.ic_white_crown_queen, name = "White Queen", description = "Moves vertically, horizontally, or diagonally"),
  PieceData(image = R.drawable.ic_white_rook, name = "White Rook", description = "Moves vertically and horizontally"),
  PieceData(image = R.drawable.ic_white_bishop, name = "White Bishop", description = "Moves diagonally"),
  PieceData(image = R.drawable.ic_white_knight, name = "White Knight", description = "Moves in shape of L"),
  PieceData(image = R.drawable.ic_white_pawn, name = "White Pawn", description = "Moves one or two steps"),
  PieceData(image = R.drawable.ic_crown_queen, name = "Black King", description = "Most important chess piece"),
  PieceData(image = R.drawable.ic_crown_king, name = "Black Queen", description = "Moves vertically, horizontally, or diagonally"),
  PieceData(image = R.drawable.ic_rook, name = "Black Rook", description = "Moves vertically and horizontally"),
  PieceData(image = R.drawable.ic_bishop, name = "Black Bishop", description = "Moves diagonally"),
  PieceData(image = R.drawable.ic_knight, name = "Black Knight", description = "Moves in shape of L"),
  PieceData(image = R.drawable.ic_pawn, name = "Black Pawn", description = "Moves one or two steps")
)