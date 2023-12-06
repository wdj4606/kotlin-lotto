package lotto.domain

data class LottoNum(val num: Int) {
    operator fun compareTo(lottoNum: LottoNum): Int {
        return num.compareTo(lottoNum.num)
    }

    init {
        require(num in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
    }

    companion object {
        val LOTTO_MIN_NUMBER = 1
        val LOTTO_MAX_NUMBER = 45
    }
}
