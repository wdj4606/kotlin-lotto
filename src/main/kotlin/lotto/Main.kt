package lotto

fun main() {
    val money = InputView.getMoney()

    val tickets = LottoVendingMachine.purchase(money)
    ResultView.printTickets(tickets)

    val winningNumbers = InputView.getWinningNumbers()
    val results = LottoEventMachine.result(winningNumbers, tickets)
    ResultView.printResult(results)

    val ratio = LottoEventMachine.ratioOfReturn(results)
    ResultView.printRatioOfReturn(ratio)
}