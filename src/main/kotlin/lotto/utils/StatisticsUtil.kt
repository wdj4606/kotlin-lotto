package lotto.utils

import lotto.domain.Lotto
import lotto.domain.LottoNum

object StatisticsUtil {
    enum class Prize(
        val prize: Int,
        val isMatched: (Lotto, Lotto, LottoNum) -> Boolean
    ) {
        THREE(
            5_000,
            { lotto, win, _ -> lotto.matchedCount(win) == 3 }
        ),
        FOUR(
            50_000,
            { lotto, win, _ -> lotto.matchedCount(win) == 4 }
        ),
        FIVE(
            1_500_000,
            { lotto, win, bonus -> lotto.matchedCount(win) == 5 && !lotto.contains(bonus) }
        ),
        FIVE_BONUS(
            30_000_000,
            { lotto, win, bonus -> lotto.matchedCount(win) == 5 && lotto.contains(bonus) }
        ),
        SIX(
            2_000_000_000,
            { lotto, win, _ -> lotto.matchedCount(win) == 6 }
        ),
    }

    fun getCountWin(lottoList: List<Lotto>, winLotto: Lotto, bonus: LottoNum): Map<Prize, Int> {
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
