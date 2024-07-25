package Lotto.domain

class LottoGame(private val money: Int = DEFAULT_MONEY) {
    fun buyLotto(): List<Lotto> {
        val lottoCount = money / Lotto.LOTTO_PRICE
        return (1..lottoCount).map { Lotto() }
    }
    companion object {
        private const val DEFAULT_MONEY = 0
        private const val NO_REWARD = 0
        private const val THREE_MATCH_REWARD = 5000
        private const val FOUR_MATCH_REWARD = 50000
        private const val FIVE_MATCH_REWARD = 1500000
        private const val SIX_MATCH_REWARD = 2000000000
    }
}
