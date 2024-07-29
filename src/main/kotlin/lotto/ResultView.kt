package lotto

import java.math.BigDecimal
import java.math.RoundingMode

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

        println("3개 일치 (${Rank.Fourth.reward}원)- ${results.count { it.rank == 4}}개")
        println("4개 일치 (${Rank.Third.reward}원)- ${results.count { it.rank == 3}}개")
        println("5개 일치 (${Rank.Second.reward}원)- ${results.count { it.rank == 2}}개")
        println("6개 일치 (${Rank.First.reward}원)- ${results.count { it.rank == 1}}개")

        println("총 수익률은 ${ratioOfReturn(results)}입니다.")
    }

    private fun ratioOfReturn(results: List<LottoResult>): BigDecimal {
        if (results.isEmpty()) {
            return BigDecimal.ZERO
        }

        var total = BigDecimal.ZERO
        for (result in results) {
            total = total.add(BigDecimal(result.reward))
        }

        val totalPrice = BigDecimal(LottoVendingMachine.PRICE).multiply(BigDecimal(results.size))
        return total.divide(totalPrice, 2, RoundingMode.HALF_UP)
    }
}