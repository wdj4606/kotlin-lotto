package lotto

object LottoNumberGenerator : GeneratorInterface {
    private const val LOTTO_NUMBER_SIZE = 6
    override fun generate(): List<Int> {
        val numbers = (1..45).toList()
        return numbers.shuffled().take(LOTTO_NUMBER_SIZE).sorted()
    }
}