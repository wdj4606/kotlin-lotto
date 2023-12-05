package lotto.utils

import lotto.domain.Lotto

class StatisticsUtil {

    companion object {
        enum class Prize(val count: Int, val prize: Int) {
            THREE(3, 5000),
            FOUR(4, 50000),
            FIVE(5, 1500000),
            SIX(6, 2000000000)
        }

        fun getCountWin(lottoList: List<Lotto>, prize: Prize): Int {
            return lottoList.count { it.matched == prize.count }
        }
    }
}
