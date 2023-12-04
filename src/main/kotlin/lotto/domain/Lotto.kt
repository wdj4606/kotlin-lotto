package lotto.domain

class Lotto(val numbers: List<Int>) : List<Int> by numbers {
    var matched: Int = 0

    init {
        require(numbers.size == LOTTO_NUM_COUNT)
        require(numbers.distinct().size == LOTTO_NUM_COUNT)
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER })
    }

    fun matchWin(winLotto: Lotto) {
        matched = this.count { winLotto.contains(it) }
    }

    companion object {
        val LOTTO_NUM_COUNT = 6
        val LOTTO_MIN_NUMBER = 1
        val LOTTO_MAX_NUMBER = 45

        fun shuffled(): Lotto {
            val numbers = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
                .shuffled()
                .take(LOTTO_NUM_COUNT)
                .sorted()
            return Lotto(numbers)
        }
    }
}
