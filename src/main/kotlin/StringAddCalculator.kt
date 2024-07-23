class StringAddCalculator {
    private val validator: FormulaValidator = FormulaValidator()
    private val parser: FormulaParser = FormulaParser()

    fun add(text: String?): Int {
        if (validator.isNullOrEmptyOrBlank(text))
            return 0

        val trySingleInt = parser.convertSingleInteger(text!!)
        trySingleInt?.let {
            require(trySingleInt >= 0) { MSG_EXCEPTION_NEGATIVE }
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
    }

    

    companion object {
        const val MSG_EXCEPTION_NEGATIVE = "음수는 허용되지 않습니다."
        const val MSG_EXCEPTION_FORMULA_ERROR = "수식이 잘못되었습니다."
    }
}