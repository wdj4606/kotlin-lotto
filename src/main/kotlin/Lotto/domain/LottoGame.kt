package Lotto.domain

object  LottoGame {
    private const val DEFAULT_MONEY = 0
    private var money: Int = DEFAULT_MONEY

    fun setMoney(amount: Int) {
        money = amount
    }

    fun buyLotto(): List<Lotto> {
        val lottoCount = money / Lotto.LOTTO_PRICE
        return (1..lottoCount).map { Lotto() }
    }

    fun match(lottos: List<Lotto>, winningNumber: List<Int>): List<Rank> {
        return lottos.map { Rank.of(it.match(winningNumber)) }
    }

    fun getReward(result: List<Rank>): Int {
        return result.sumOf { it.reward }
    }

    fun calculateRate(reward: Int): Double {
        return (reward.toDouble() / money * 100).let {
            String.format("%.2f", it).toDouble()
        }
    }
}

enum class Rank(val count: Int, val reward: Int) {
    NO_REWARD(0, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    companion object {
        fun of(count: Int): Rank {
            return values().find { it.count == count } ?: NO_REWARD
        }
    }
}
