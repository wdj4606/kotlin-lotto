package lotto.utils

class StringSplitter {
    companion object {
        fun splitByDelimiters(input: String, delimiters: List<Char>): List<Int> {
            val regex = delimiters.joinToString(prefix = "[", postfix = "]").toRegex()
            return input
                .split(regex)
                .map { it.toInt() }
        }
    }
}
