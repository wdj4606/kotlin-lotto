package Lotto.domain

class LottoGame(private val money: Int = DEFAULT_MONEY) {

    fun buyLotto(): List<Lotto> {
        val lottoCount = money / Lotto.LOTTO_PRICE
        return (1..lottoCount).map { Lotto() }
    }

    fun match(lottos: List<Lotto>, winningNumber: List<Int>): List<Int> {
        return lottos.map { it.match(winningNumber) }
    }

    fun getReward(result: List<Int>): Int {
        val rewardList = listOf(
            NO_REWARD, NO_REWARD, NO_REWARD,
            THREE_MATCH_REWARD,
            FOUR_MATCH_REWARD,
            FIVE_MATCH_REWARD,
            SIX_MATCH_REWARD)
        return result.map { rewardList[it] }.sum()
    }

    fun calculateRate(reward: Int): Double {
        return (reward.toDouble() / money * 100).let {
            String.format("%.2f", it).toDouble()
        }
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
