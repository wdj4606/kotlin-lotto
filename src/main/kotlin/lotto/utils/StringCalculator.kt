package lotto.utils

class StringCalculator {
    fun calc(input: String): Int {
        val delimiters = StringSplitter.getDelimiters(input)

        return StringSplitter
            .splitByDelimiters(input, delimiters)
            .sum()
    }
}
