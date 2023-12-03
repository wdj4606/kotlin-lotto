package lotto.utils

class StringCalculator {
    fun calc(input: String): Int {
        require(input.isNotBlank()) { "input is empty" }

        return StringSplitter
            .splitByDelimiters(input, listOf(',', ':'))
            .sum()
    }
}
