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
        StatisticsUtil.Companion.Prize.values().forEach {
            val countWin = StatisticsUtil.getCountWin(lottoList, it)
            println("$it matched (${it.prize}) : $countWin ")
            totalPrize += countWin * it.prize
        }
        val profit: Double = totalPrize.toDouble() / (lottoList.size * 1000).toDouble()
        println("total prize : $totalPrize, profit : $profit")
    }
}
