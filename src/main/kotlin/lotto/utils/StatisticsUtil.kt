package lotto.utils

import lotto.domain.Lotto

class StatisticsUtil {

    companion object {
        val PRIZE = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 1500000,
            6 to 2000000000
        )

        val TARGET_MATCHED = listOf(3, 4, 5, 6)

        fun getCountWin(lottoList: List<Lotto>, matchedCount: Int): Int {
            return lottoList.count { it.matched == matchedCount }
        }

        fun getPrize(matchedCount: Int): Int {
            return PRIZE.get(matchedCount)
                ?: throw RuntimeException("prize not found")
        }
    }
}
