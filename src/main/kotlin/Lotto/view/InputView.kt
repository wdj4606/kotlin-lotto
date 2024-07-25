package Lotto.view

class InputView {
    companion object {
        fun inputMoney(): Int {
            println("구입금액을 입력해 주세요.")
            return readlnOrNull()?.toInt() ?: inputMoney()
        }

        fun inputWinningNumber(): List<Int> {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return readlnOrNull()?.split(",")?.map { it.toInt() } ?: inputWinningNumber()
        }
    }
}