package Lotto.domain

import Lotto.domain.LottoNumberGenerator.generate

class Lotto(val number: List<Int> = generate()) {

    init {
        require(number.size == LOTTO_SIZE) { ERROR_MESSAGE_SIZE }
        require(number.all { it in 1..LOTTO_MAX_NUMBER }) { ERROR_MESSAGE_NUMBER_RANGE }
    }

    fun match(winningNumber: List<Int>): Int {
        return number.intersect(winningNumber.toSet()).count()
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_SIZE = 6
        const val LOTTO_MAX_NUMBER = 45

        private const val ERROR_MESSAGE_SIZE = "로또 번호는 6개여야 합니다."
        private const val ERROR_MESSAGE_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}