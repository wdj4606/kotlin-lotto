package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNum
import lotto.utils.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    inputView.inputMoney()
    inputView.inputManualCount()

    val lottoCount: Int = inputView.money / 1000
    require(lottoCount >= inputView.manualCount) { "manual lotto count too big" }
    val autoCount = lottoCount - inputView.manualCount
    val manualLottoList = inputView.inputManual()
        .map { numList -> Lotto(numList.map { num -> LottoNum(num) }) }

    outputView.printLottoCount(autoCount, inputView.manualCount)

    val autoLottoList = List(autoCount) { LottoMachine.auto() }
    outputView.printLotto(autoLottoList)

    val winNumbers = inputView.inputWin()
    val bonus = LottoNum(inputView.inputBonus())
    val winLotto = Lotto(*winNumbers.toIntArray())
    val totalLottoList = manualLottoList + autoLottoList

    outputView.printStatistics(totalLottoList, winLotto, bonus)
}
