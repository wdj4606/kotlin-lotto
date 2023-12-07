package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNum
import lotto.utils.StatisticsUtil

class OutputView {
    fun printLottoCount(lottoCount: Int) {
        println("bought lotto $lottoCount.")
    }

    fun printLotto(lotto: Lotto) {
        println("[ ${lotto.map { it.num }.joinToString(", ")} ]")
    }

    fun printStatistics(lottoList: List<Lotto>, winLotto: Lotto, bonus: LottoNum) {
        println()
        println("=== Statistics ===")
        println()

        val winCount = StatisticsUtil.getCountWin(lottoList, winLotto, bonus)
        val totalPrize = StatisticsUtil.getTotalProfit(winCount)
        val profit = totalPrize.toDouble() / (lottoList.size * 1000).toDouble()

        val printPrizeResult = { prize: StatisticsUtil.Prize, name: String ->
            println("$name (${prize.prize}) : ${winCount[prize]} ")
        }
        printPrizeResult(StatisticsUtil.Prize.THREE, "3 matched")
        printPrizeResult(StatisticsUtil.Prize.FOUR, "4 matched")
        printPrizeResult(StatisticsUtil.Prize.FIVE, "5 matched")
        printPrizeResult(StatisticsUtil.Prize.FIVE_BONUS, "5 matched and bonus")
        printPrizeResult(StatisticsUtil.Prize.SIX, "6 matched")

        println("total prize : $totalPrize, profit : $profit")
    }
}
