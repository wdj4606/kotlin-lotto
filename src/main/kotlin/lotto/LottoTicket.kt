package lotto

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

class LottoTicket(private val generatorParam: GeneratorInterface = LottoNumberGenerator, val numbers: List<Int> = List(6) {generatorParam.generate()}.sorted()) {
    fun result(winningNumbers: List<Int>): LottoResult {
        val count = winningNumberCount(winningNumbers)
        val rank = Rank.getByMatch(count)
        return LottoResult(rank.rank, Rank.getByRank(rank.rank).reward, this)
    }

    private fun winningNumberCount(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }
}