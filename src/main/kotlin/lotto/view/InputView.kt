package lotto.view

import lotto.utils.StringCalculatorValidator

class InputView {
    var money: Int = 0
    var manualCount: Int = 0
    fun inputMoney() {
        print("pay for lotto : ")
        money = readln().toInt()
        println()
    }
    fun inputManualCount() {
        print("manual lotto count : ")
        manualCount = readln().toInt()
        println()
    }
    fun inputManual(): List<List<Int>> {
        val manualLottoList = mutableListOf<List<Int>>()
        println("manual lotto : ")
        repeat(manualCount) {
            manualLottoList.add(readln().split(",").map { StringCalculatorValidator.getValue(it) })
        }
        println()
        return manualLottoList
    }
    fun inputWin(): List<Int> {
        print("win lotto : ")
        return readln().split(",").map { StringCalculatorValidator.getValue(it) }
    }

    fun inputBonus(): Int {
        print("bonus lotto : ")
        return readln().toInt()
    }
}
