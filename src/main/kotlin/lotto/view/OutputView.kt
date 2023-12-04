package lotto.view

import lotto.domain.Lotto

class OutputView {
    fun printLottoCount(lottoCount: Int) {
        println("bought lotto $lottoCount.")
    }

    fun pintLotto(lotto: Lotto) {
        println("[ ${lotto.joinToString(", ")} ]")
    }
}
