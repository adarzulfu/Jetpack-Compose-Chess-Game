package com.example.chessgame.presentation.chess_game

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
            boardMember.chessPiece?.apply {
                selectedChessItemPosition = squareList.indexOf(boardMember)
                squareList = squareList.toMutableList().also {
                    it[selectedChessItemPosition] = BoardMember(isSelected = true, chessPiece = boardMember.chessPiece)
                }
            }

        } else {
            val nextPosition = squareList.indexOf(boardMember)
            squareList = squareList.toMutableList().also {
                if (nextPosition != selectedChessItemPosition) {
                    it[nextPosition] = squareList[selectedChessItemPosition].apply { isSelected = false }
                    it[selectedChessItemPosition] = BoardMember(null)
                } else {
                    it[selectedChessItemPosition] = BoardMember(isSelected = false, chessPiece = boardMember.chessPiece)
                }
            }
            selectedChessItemPosition = -1
        }
    }


}

