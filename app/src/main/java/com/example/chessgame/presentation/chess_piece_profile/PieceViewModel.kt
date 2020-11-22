package com.example.chessgame.presentation.chess_piece_profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class PieceViewModel : ViewModel() {

    private val _pieceList = MutableLiveData<List<PieceData>>()
    val pieceList: LiveData<List<PieceData>>
        get() = _pieceList

    var pieceListState by mutableStateOf(listOf<PieceData>())
        private set

    fun initPieceListData() {
        _pieceList.value = pieceListData
        pieceListState = pieceListData
    }
}