package lotto.domain

class Lotto(val numbers: List<Int>) : List<Int> by numbers {

    constructor(vararg numbers: Int) : this(numbers.toList().distinct().sorted())

    init {
        require(numbers.size == LOTTO_NUM_COUNT)
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER })
    }

    fun matchedCount(winLotto: Lotto): Int {
        return this.count { winLotto.contains(it) }
    }

    companion object {
        val LOTTO_NUM_COUNT = 6
        val LOTTO_MIN_NUMBER = 1
        val LOTTO_MAX_NUMBER = 45

        val LOTTO_FULL_NUMBERS = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).toList()

        fun shuffled(): Lotto {
            val numbers = LOTTO_FULL_NUMBERS
                .shuffled()
                .take(LOTTO_NUM_COUNT)
                .sorted()
                .toList()
            return Lotto(numbers)
        }
    }
}
