package lotto.domain

class Lotto(val numbers: List<LottoNum>) : List<LottoNum> by numbers {

    init {
        require(numbers.size == LOTTO_NUM_COUNT)
    }

    constructor(vararg nums: Int) :
        this(List(nums.size) { LottoNum(nums[it]) }.sortedBy { it.num }.distinct())

    fun matchedCount(winLotto: Lotto): Int {
        return this.count { winLotto.contains(it) }
    }

    fun contains(lottoNum: Int): Boolean {
        return numbers.contains(LottoNum(lottoNum))
    }

    companion object {
        val LOTTO_NUM_COUNT = 6
        val LOTTO_FULL_NUMBERS = (LottoNum.LOTTO_MIN_NUMBER..LottoNum.LOTTO_MAX_NUMBER).toList()

        fun shuffled(): Lotto {
            val numbers = LOTTO_FULL_NUMBERS
                .shuffled()
                .take(LOTTO_NUM_COUNT)
                .sorted()
                .map { LottoNum(it) }
            return Lotto(numbers)
        }
    }
}
