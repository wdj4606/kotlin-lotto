package Calculator

class StringAddCalculator
    (private val delimiterManager: DelimiterManager = DelimiterManager(),
     private val tokenValidator: TokenValidator = TokenValidator())
{
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