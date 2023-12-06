package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNum
import lotto.utils.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    inputView.input()

    val lottoCount: Int = inputView.money / 1000
    outputView.printLottoCount(lottoCount)

    val lottoList = List(lottoCount) { LottoMachine.auto() }
    lottoList.forEach { outputView.printLotto(it) }

    val winNumbers = inputView.inputWin()
    val bonus = LottoNum(inputView.inputBonus())
    val winLotto = Lotto(*winNumbers.toIntArray())

    outputView.printStatistics(lottoList, winLotto, bonus)
}
