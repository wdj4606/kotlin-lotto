package Lotto.view

class InputView {
    companion object {
        fun inputMoney(): Int {
            println("구입금액을 입력해 주세요.")
            return readlnOrNull()?.toInt() ?: inputMoney()
        }
    }
}