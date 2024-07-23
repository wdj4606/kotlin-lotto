object StringValidator {
    const val MSG_EXCEPTION_NEGATIVE = "음수는 허용되지 않습니다."
    const val MSG_EXCEPTION_FORMULA_ERROR = "수식이 잘못되었습니다."

    fun isNullOrEmptyOrBlank(text: String?): Boolean {
        return text.isNullOrEmpty() || text.isBlank()
    }

    fun convertSingleInteger(text: String): Int? {
        return try {
            text.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }

    fun convertValidateStringToNumber(text: String): Int {
        val trySingleInt = convertSingleInteger(text)
        require (trySingleInt != null) { MSG_EXCEPTION_FORMULA_ERROR }
        require(trySingleInt >= 0) { MSG_EXCEPTION_NEGATIVE }
        return trySingleInt
    }
}