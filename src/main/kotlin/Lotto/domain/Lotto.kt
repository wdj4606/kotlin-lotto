package Lotto.domain

class Lotto {
    val number = generate()

    private fun generate(): List<Int> {
        return (1..45).shuffled().take(6).sorted()
    }

    fun match(winningNumber: List<Int>): Int {
        return number.intersect(winningNumber.toSet()).count()
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}