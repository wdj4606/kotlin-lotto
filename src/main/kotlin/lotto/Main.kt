package lotto

fun main() {
    val money = InputView.getMoney()

    val tickets = LottoVendingMachine.purchase(money)
    ResultView.printTickets(tickets)

    val winningNumbers = InputView.getWinningNumbers()
    val results = tickets.map { ticket -> ticket.result(winningNumbers) }

    ResultView.printResult(results)
}
