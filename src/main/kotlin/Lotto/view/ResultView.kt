package Lotto.view

import Lotto.domain.Lotto
import Lotto.domain.Rank

object ResultView {

    fun printBuyLotto(lottoCount: Int) {
        println("$lottoCount 개를 구매했습니다.")
    }

    fun printLotto(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            println(lotto.number)}
    }

    fun printResult(result: List<Rank>, rate: Double) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${result.count { it == Rank.THREE_MATCH }}개")
        println("4개 일치 (50000원)- ${result.count { it == Rank.FOUR_MATCH }}개")
        println("5개 일치 (1500000원)- ${result.count { it == Rank.FIVE_MATCH }}개")
        println("6개 일치 (2000000000원)- ${result.count { it == Rank.SIX_MATCH }}개")
        println("총 수익률은 ${rate}% 입니다.")
    }
}