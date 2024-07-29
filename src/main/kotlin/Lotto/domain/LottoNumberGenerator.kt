package Lotto.domain

object LottoNumberGenerator {

    fun generate(): List<Int> {
        return (1..45).shuffled().take(6).sorted()
    }
}