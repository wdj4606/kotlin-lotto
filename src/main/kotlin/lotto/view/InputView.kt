package lotto.view

class InputView {
    var money: Int = 0
    fun input() {
        print("pay for lotto : ")
        money = readln().toInt()
    }
}
