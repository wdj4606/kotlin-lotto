package lotto

class LottoTicket(val numbers: List<Int> = List(6) { LottoNumberGenerator.generate() }.sorted())