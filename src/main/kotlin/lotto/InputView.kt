package lotto

object InputView {
    fun getMoney(): Int {
        println("구입금액을 입력해 주세요.")

        val input: String = readln()

        require(input.isNotEmpty()) { "입력이 비어있음" }
        val integer = input.toIntOrNull()
        require(integer != null) { "숫자가 아님" }
        require(integer >= 0) { "음수임" }
        return integer
    }

    fun getWinningNumbers(): List<Int> {
        println("")
        println("지난 주 당첨 번호를 입력해 주세요.")

        val input: String = readln()
        return input.split(",").map { it.toInt() }
    }
}