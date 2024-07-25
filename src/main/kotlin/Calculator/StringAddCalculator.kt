package Calculator

fun main() {
    val calculator = StringAddCalculator()
    println(calculator.add("//k\n1,2:3k1"))
    println(calculator.add("1,2:3"))
    println(calculator.add("a"))
}

class StringAddCalculator {
    private val delimiterManager = DelimiterManager()
    private val tokenValidator = TokenValidator()

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        return calculate(delimiterManager.getTokens(text))
    }

    private fun calculate(tokens: List<String>): Int {
        return tokens
            .map { tokenValidator.validate(it) }
            .sum()
    }
}