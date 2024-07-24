package lotto

object LottoNumberGenerator : GeneratorInterface {
    override fun generate(): Int {
        val range = (1..45)
        return range.random()
    }
}