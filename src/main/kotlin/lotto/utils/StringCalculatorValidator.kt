package lotto.utils

class StringCalculatorValidator {
    companion object {
        fun getValue(value: String): Int {
            val result = value.toIntOrNull()
                ?: throw RuntimeException("input is not number")
            require(result >= 0) { "input is negative" }
            return result
        }
    }
}
