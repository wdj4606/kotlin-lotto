package lotto.view

import lotto.utils.StringCalculatorValidator

class InputView {
    var money: Int = 0
    fun input() {
        print("pay for lotto : ")
        money = readln().toInt()
    }
    fun inputWin(): List<Int> {
        print("win lotto : ")
        return readln().split(",").map { StringCalculatorValidator.getValue(it) }
    }
}
