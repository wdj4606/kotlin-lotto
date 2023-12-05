package lotto.utils

import lotto.domain.Lotto

object StatisticsUtil {
    enum class Prize(val count: Int, val prize: Int) {
        THREE(3, 5000),
        FOUR(4, 50000),
        FIVE(5, 1500000),
        SIX(6, 2000000000)
    }

    fun getCountWin(lottoList: List<Lotto>): Map<Prize, Int> {
        val result = mutableMapOf<Prize, Int>()
        Prize.values().forEach {
            result[it] = lottoList.count { lotto -> lotto.matched == it.count }
        }
        return result
    }

    fun getTotalProfit(winMap: Map<Prize, Int>): Int {
        var totalPrize = 0
        winMap.forEach {
            totalPrize += it.key.prize * it.value
        }
        return totalPrize
    }
}
