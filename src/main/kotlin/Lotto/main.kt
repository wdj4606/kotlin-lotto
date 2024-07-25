package Lotto

import Lotto.domain.LottoGame
import Lotto.view.InputView
import Lotto.view.ResultView

fun main() {
    LottoGame(InputView.inputMoney()).run {
        val lottos = buyLotto()
        ResultView.printBuyLotto(lottos.size)
        ResultView.printLotto(lottos)
        val winningNumber = InputView.inputWinningNumber()
        val result = match(lottos, winningNumber)
        val reward = getReward(result)
        ResultView.printResult(result, calculateRate(reward))
    }
}