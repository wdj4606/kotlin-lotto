package lotto.utils

import lotto.domain.Lotto
import lotto.domain.LottoNum

class LottoMachine {

    companion object {
        val LOTTO_FULL_NUMBERS = (LottoNum.LOTTO_MIN_NUMBER..LottoNum.LOTTO_MAX_NUMBER).toList()

        fun auto(): Lotto {
            val numbers = LOTTO_FULL_NUMBERS
                .shuffled()
                .take(Lotto.LOTTO_NUM_COUNT)
                .sorted()
                .map { LottoNum(it) }
            return Lotto(numbers)
        }

        fun manual(numbers: List<Int>): Lotto {
            val lottoNums = numbers
                .map { LottoNum(it) }
                .distinct()
                .sortedBy { it.num }
            return Lotto(lottoNums)
        }
    }
}
