package lotto

import java.math.BigDecimal
import java.math.RoundingMode

enum class Rank(val rank: Int, val reward: Int, val match: Int) {
    First(1, 2000000000, 6),
    Second(2, 1500000, 5),
    Third(3, 50000, 4),
    Fourth(4, 5000, 3),
    Fifth(5, 0, 2);

    companion object {
        fun getByRank(rank: Int): Rank {
            return when (rank) {
                1 -> First
                2 -> Second
                3 -> Third
                4 -> Fourth
                else -> Fifth
            }
        }

        fun getByMatch(match: Int): Rank {
            return when (match) {
                6 -> First
                5 -> Second
                4 -> Third
                3 -> Fourth
                else -> Fifth
            }
        }
    }
}


data class LottoResult(val rank: Int, val reward: Int, val ticket: LottoTicket)
object LottoEventMachine {
    fun result(winningNumbers: List<Int>, tickets: List<LottoTicket>): MutableList<LottoResult> {
        val results: MutableList<LottoResult> = mutableListOf()
        for (ticket in tickets) {
            val count = winningNumberCount(ticket.numbers, winningNumbers)
            val rank = Rank.getByMatch(count)
            results.add(LottoResult(rank.rank, Rank.getByRank(rank.rank).reward, ticket))
        }
        return results
    }

    fun ratioOfReturn(results: List<LottoResult>): BigDecimal {
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

    private fun winningNumberCount(numbers: List<Int>, winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }
}