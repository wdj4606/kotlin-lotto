class StringAddCalculator {
    private val validator: FormulaValidator = FormulaValidator()
    private val parser: FormulaParser = FormulaParser()

    fun add(text: String?): Int {
        if (validator.isNullOrEmptyOrBlank(text))
            return 0

        val trySingleInt = parser.convertSingleInteger(text!!)
        trySingleInt?.let {
            return trySingleInt
        }

        val splitStrings = parser.splitByDelimiter(text)

        val splitNumbers: MutableList<Int> = mutableListOf()
        for (splitString in splitStrings) {
            val splitInt = parser.convertSingleInteger(splitString)
            require(splitInt != null) { MSG_EXCEPTION_FORMULA_ERROR }
            splitNumbers.add(splitInt)
        }

        var sum = 0
        for (splitNumber in splitNumbers) {
            sum += splitNumber
        }

        return sum

//        if (isSingleInteger(text)) {
//            return checkPostiveIntegerAndReturn(text)
//        }
//
//        var finalText: String = text
//        val resultPair = getDelimiterAndRemainingText(text)
//        if (resultPair.first != null && resultPair.second != null) {
//            finalText = resultPair.second!!
//        }
    }

//    private fun checkPostiveIntegerAndReturn(text: String): Int {
//        val positive = text.toInt()
//        check(positive >= 0) { throw NumberFormatException(MSG_EXCEPTION_NEGATIVE) }
//        return positive
//    }
//
//    private fun getDelimiterAndRemainingText(text: String): Pair<String?, String?> {
//        val result = Regex("//(.)\n(.*)").find(text)
//        val delimiter = result?.groupValues?.get(1)
//        val remainingText = result?.groupValues?.get(2)
//        return Pair(delimiter, remainingText)
//    }
//
//    private fun splitAndAdd(text: String, delimiter: String?): Int {
//        val delimiters = mutableListOf("[,:]")
//
//        delimiter?.let {
//            delimiters.add(Regex.escape(it))
//        }
//
//        val combinedRegex = delimiters.joinToString(separator = "|") { it }
//        val numbers = text.split(combinedRegex.toRegex())
//
//        var sum = 0
//        for (number in numbers) {
//            require(isSingleInteger(number)) { MSG_EXCEPTION_FORMULA_ERROR }
//            sum += checkPostiveIntegerAndReturn(number)
//        }
//        return sum
//    }
//
    companion object {
//        const val MSG_EXCEPTION_NEGATIVE = "음수는 허용되지 않습니다."
        const val MSG_EXCEPTION_FORMULA_ERROR = "수식이 잘못되었습니다."
    }
}