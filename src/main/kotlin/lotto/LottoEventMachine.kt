package lotto

data class LottoResult(val rank: Int, val reward: Int, val ticket: LottoTicket)
object LottoEventMachine {
    private const val REWARD_1ST = 2000000000
    private const val REWARD_2ND = 1500000
    private const val REWARD_3RD = 50000
    private const val REWARD_4TH = 5000
    private const val REWARD_5TH = 0
    private val REWARD_VALUES = listOf(REWARD_1ST, REWARD_2ND, REWARD_3RD, REWARD_4TH, REWARD_5TH)

    fun result(winningNumbers: List<Int>, tickets: List<LottoTicket>): MutableList<LottoResult> {
        val results: MutableList<LottoResult> = mutableListOf()
        for (ticket in tickets) {
            val count = winningNumberCount(ticket.numbers, winningNumbers)
            val rank = matchCount2Rank(count)
            results.add(LottoResult(rank, REWARD_VALUES[rank - 1], ticket))
        }
        return results
    }

    private fun matchCount2Rank(count: Int): Int {
        return when (count) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            else -> 5
        }
    }

    private fun winningNumberCount(numbers: List<Int>, winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }
}