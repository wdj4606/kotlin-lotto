package lotto

import java.math.BigDecimal

object ResultView {
    fun printTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")

        for (ticket in tickets) {
            printTicket(ticket)
        }
    }

    private fun printTicket(ticket: LottoTicket) {
        val result = ticket.numbers.joinToString(prefix = "[", postfix = "]")
        println(result)
    }

    fun printResult(results: List<LottoResult>) {
        println("")
        println("당첨 통계")
        println("---------")

        println("3개 일치 (${LottoEventMachine.REWARD_4TH}원)- ${results.count { it.rank == 4}}개")
        println("4개 일치 (${LottoEventMachine.REWARD_3RD}원)- ${results.count { it.rank == 3}}개")
        println("5개 일치 (${LottoEventMachine.REWARD_2ND}원)- ${results.count { it.rank == 2}}개")
        println("6개 일치 (${LottoEventMachine.REWARD_1ST}원)- ${results.count { it.rank == 1}}개")

    }

    fun printRatioOfReturn(ratio: BigDecimal) {
        println("총 수익률은 ${ratio}입니다.")
    }
}