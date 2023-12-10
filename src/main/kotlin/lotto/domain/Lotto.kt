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
    }
}
