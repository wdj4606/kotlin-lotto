package Lotto.view

import Lotto.domain.Lotto

class ResultView {
    companion object {
        fun printBuyLotto(lottoCount: Int) {
            println("$lottoCount 개를 구매했습니다.")
        }

        fun printLotto(lottos: List<Lotto>) {
            lottos.forEach { lotto ->
                println(lotto.number)}
        }

        fun printResult(result: List<Int>, rate: Double) {
            println("당첨 통계")
            println("---------")
            println("3개 일치 (5000원)- ${result.count { it == 3 }}개")
            println("4개 일치 (50000원)- ${result.count { it == 4 }}개")
            println("5개 일치 (1500000원)- ${result.count { it == 5 }}개")
            println("6개 일치 (2000000000원)- ${result.count { it == 6 }}개")
            println("총 수익률은 ${rate}% 입니다.")
        }
    }
}