package lotto.utils

class StringSplitter {
    companion object {
        fun getDelimiters(input: String): List<Char> {
            val result = Regex("//(.)\n").find(input)
                ?.value
                ?.get(CUSTOM_DELIMITER_INDEX)
                ?: throw IllegalArgumentException("invalid input")
            return listOf(result)
        }
        fun splitByDelimiters(input: String, delimiters: List<Char>): List<Int> {
            val regex = delimiters.joinToString(prefix = "[", postfix = "]").toRegex()
            return input
                .split(regex)
                .map { it.toInt() }
        }

        val CUSTOM_DELIMITER_INDEX = 2
    }
}
