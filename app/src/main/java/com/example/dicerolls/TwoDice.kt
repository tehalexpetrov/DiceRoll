package com.example.dicerolls

class TwoDice(val numSide: Int) {
    fun rolling(): Int {
        return (1..numSide).random()
    }
}