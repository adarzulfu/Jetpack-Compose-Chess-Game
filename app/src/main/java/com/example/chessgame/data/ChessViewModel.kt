package com.example.chessgame.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ChessViewModel : ViewModel() {


    var squareList by mutableStateOf(listOf<BoardMember>())
        private set

    private var selectedChessItemPosition: Int = -1


    fun initSquarePeaces() {
        squareList = createInitialSquares()
    }

    fun onSquareSelected(boardMember: BoardMember) {
        if (selectedChessItemPosition == -1) {
            selectedChessItemPosition = squareList.indexOf(boardMember)
            squareList = squareList.toMutableList().also {
                it[selectedChessItemPosition] = BoardMember(isSelected = true, chessPiece = boardMember.chessPiece)
            }

        } else {
            val currentSelectedPosition = squareList.indexOf(boardMember)
            squareList = squareList.toMutableList().also {
                it[currentSelectedPosition] = squareList[selectedChessItemPosition].apply { isSelected = false }
                it[selectedChessItemPosition] = BoardMember(null)
            }
            selectedChessItemPosition = -1
        }
    }

    private fun createInitialSquares(): ArrayList<BoardMember> {
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

}

