package lotto

object LottoNumberGenerator {
    fun generate(): Int {
        val range = (1..45)
        return range.random()
    }
}