package lotto.utils

class StringSplitter {
    companion object {
        fun getDelimiters(input: String): List<Char> {
            val result = Regex(DELIMITER_PATTERN).find(input)
                ?.value
                ?.get(CUSTOM_DELIMITER_INDEX)
            return result?.let { listOf(it) } ?: DEFAULT_DELIMITERS
        }
        fun splitByDelimiters(calcInput: String, delimiters: List<Char>): List<Int> {
            val input = calcInput.replace(DELIMITER_PATTERN.toRegex(), "")
            if (input.isBlank()) return listOf()

            val regex = delimiters.joinToString(prefix = "[", postfix = "]").toRegex()
            return input
                .split(regex)
                .map { StringCalculatorValidator.getValue(it) }
        }

        val CUSTOM_DELIMITER_INDEX = 2
        val DELIMITER_PATTERN = "//(.)\n"
        val DEFAULT_DELIMITERS = listOf(',', ':')
    }
}
