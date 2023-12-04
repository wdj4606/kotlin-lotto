package lotto.view

import lotto.domain.Lotto
import lotto.utils.StatisticsUtil

class OutputView {
    fun printLottoCount(lottoCount: Int) {
        println("bought lotto $lottoCount.")
    }

    fun printLotto(lotto: Lotto) {
        println("[ ${lotto.joinToString(", ")} ]")
    }

    fun printStatistics(lottoList: List<Lotto>) {
        println()
        println("=== Statistics ===")
        println()

        var totalPrize = 0
        StatisticsUtil.TARGET_MATCHED.forEach {
            val countWin = StatisticsUtil.getCountWin(lottoList, it)
            val prize = StatisticsUtil.getPrize(it)
            println("$it matched ($prize) : $countWin ")
            totalPrize += countWin * prize
        }
        val profit: Double = totalPrize.toDouble() / (lottoList.size * 1000).toDouble()
        println("total prize : $totalPrize, profit : $profit")
    }
}
