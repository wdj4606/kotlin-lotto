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

        winCount.forEach {
            println("${it.key.printName} (${it.key.prize}) : ${it.value} ")
        }
        println("total prize : $totalPrize, profit : $profit")
    }
}
