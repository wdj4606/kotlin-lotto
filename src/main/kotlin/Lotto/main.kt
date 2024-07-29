package Lotto

import Lotto.domain.LottoGame.buyLotto
import Lotto.domain.LottoGame.calculateRate
import Lotto.domain.LottoGame.getReward
import Lotto.domain.LottoGame.setMoney
import Lotto.domain.LottoGame.match
import Lotto.view.InputView
import Lotto.view.ResultView

fun main() {
    val money = InputView.inputMoney()
    setMoney(money)

    val lottos = buyLotto()
    ResultView.printBuyLotto(lottos.size)
    ResultView.printLotto(lottos)

    val winningNumber = InputView.inputWinningNumber()
    val result = match(lottos, winningNumber)
    val reward = getReward(result)

    ResultView.printResult(result, calculateRate(reward))
}