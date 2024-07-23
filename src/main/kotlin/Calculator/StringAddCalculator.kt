package Calculator

class StringAddCalculator {
    private var delimiter = DEFAULT_DELIMITER

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        val (customDelimiter, remainingText) = getDelimiterAndText(text)
        plusDelimiter(customDelimiter)

        return calculate(requireNotNull(remainingText) { NULL })
    }

    private fun calculate(text: String): Int {
        return text.split(Regex(delimiter))
            .map { validate(it) }
            .sum()
    }

    private fun getDelimiterAndText(text: String): Pair<String?, String> {
        val result = Regex("//(.)\n(.*)").find(text)
        val delimiter = result?.groupValues?.get(1)
        val remainingText = result?.groupValues?.get(2) ?: text
        return Pair(delimiter, remainingText)
    }

    private fun plusDelimiter(newDelimiter: String?) {
        if (!newDelimiter.isNullOrBlank()) {
            delimiter = "$delimiter|$newDelimiter"
        }
    }

    private fun validate(value: String): Int {
        val number = value.toIntOrNull()
        require(number != null) { NOT_NUMBER }
        require(number >= 0) { NEGATIVE }
        return number
    }

    companion object {
        private const val DEFAULT_DELIMITER = ",|:"
        private const val NEGATIVE = "input is negative"
        private const val NULL = "text is null"
        private const val NOT_NUMBER = "input is not number"
    }
}