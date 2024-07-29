package lotto

object LottoVendingMachine {
    const val PRICE = 1000

    fun purchase(money: Int): MutableList<LottoTicket> {
        val count = money / PRICE
        val tickets = mutableListOf<LottoTicket>()
        repeat(count) {
            tickets.add(LottoTicket(LottoNumberGenerator.generate()))
        }
        return tickets
    }
}
