package lotto.utils

import lotto.domain.Lotto

object StatisticsUtil {
    enum class Prize(
        val printName: String,
        val prize: Int,
        val isMatched: (Lotto, Lotto, Int) -> Boolean
    ) {
        THREE(
            "3 matched", 5000,
            { lotto, win, _ -> lotto.matchedCount(win) == 3 }
        ),
        FOUR(
            "4 matched", 50000,
            { lotto, win, _ -> lotto.matchedCount(win) == 4 }
        ),
        FIVE(
            "5 matched", 1500000,
            { lotto, win, bonus -> lotto.matchedCount(win) == 5 && !lotto.contains(bonus) }
        ),
        FIVE_BONUS(
            "5 and bonus matched", 30000000,
            { lotto, win, bonus -> lotto.matchedCount(win) == 5 && lotto.contains(bonus) }
        ),
        SIX(
            "6 matched", 2000000000,
            { lotto, win, _ -> lotto.matchedCount(win) == 6 }
        ),
    }

    fun getCountWin(lottoList: List<Lotto>, winLotto: Lotto, bonus: Int): Map<Prize, Int> {
        val result = mutableMapOf<Prize, Int>()
        Prize.values().forEach {
            result[it] = lottoList.count { lotto -> it.isMatched(lotto, winLotto, bonus) }
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
