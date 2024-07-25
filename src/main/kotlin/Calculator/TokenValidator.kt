package Calculator

class TokenValidator {
    fun validate(value: String): Int {
        val number = value.toIntOrNull()
        require(number != null) { NOT_NUMBER }
        require(number >= 0) { NEGATIVE }
        return number
    }

    companion object {
        private const val NEGATIVE = "input is negative"
        private const val NOT_NUMBER = "input is not number"
    }
}