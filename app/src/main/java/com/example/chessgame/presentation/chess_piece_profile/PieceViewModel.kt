package com.example.chessgame.presentation.chess_piece_profile

import android.os.CountDownTimer
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

        object : CountDownTimer((pieceListData.size * 1000).toLong(), 1000) {
            var counter = 1
            override fun onTick(millisUntilFinished: Long) {
                _pieceList.value = pieceListData.subList(0, counter).toMutableList()
                pieceListState = pieceListData.subList(0, counter).toMutableList()
                counter++
            }

            override fun onFinish() {

            }
        }.start()
    }
}