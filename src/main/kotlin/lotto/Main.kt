package lotto

import lotto.domain.Lotto
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    inputView.input()

    val lottoCount: Int = inputView.money / 1000
    outputView.printLottoCount(lottoCount)

    val lottoList = List(lottoCount) { Lotto.shuffled() }
    lottoList.forEach { outputView.printLotto(it) }

    val winLotto = Lotto(inputView.winLotto())
    for (lotto in lottoList) {
        lotto.matchWin(winLotto)
    }

    outputView.printStatistics(lottoList)
}
