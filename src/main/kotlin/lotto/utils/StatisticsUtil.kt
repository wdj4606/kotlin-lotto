package lotto.utils

import lotto.domain.Lotto
import lotto.domain.LottoWin

object StatisticsUtil {
    enum class Prize(
        val prize: Int,
        val isMatched: (Lotto, LottoWin) -> Boolean
    ) {
        THREE(
            5_000,
            { lotto, win -> lotto.matchedCount(win.lotto) == 3 }
        ),
        FOUR(
            50_000,
            { lotto, win -> lotto.matchedCount(win.lotto) == 4 }
        ),
        FIVE(
            1_500_000,
            { lotto, win -> lotto.matchedCount(win.lotto) == 5 && !lotto.contains(win.bonus) }
        ),
        FIVE_BONUS(
            30_000_000,
            { lotto, win -> lotto.matchedCount(win.lotto) == 5 && lotto.contains(win.bonus) }
        ),
        SIX(
            2_000_000_000,
            { lotto, win -> lotto.matchedCount(win.lotto) == 6 }
        ),
    }

    fun getCountWin(lottoList: List<Lotto>, winLotto: LottoWin): Map<Prize, Int> {
        val result = mutableMapOf<Prize, Int>()
        Prize.values().forEach {
            result[it] = lottoList.count { lotto -> it.isMatched(lotto, winLotto) }
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
