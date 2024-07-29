class StringAddCalculator {
    private val splitter: StringSplitter = StringSplitter()

    fun add(text: String?): Int {
        if (StringValidator.isNullOrEmptyOrBlank(text))
            return 0

        val splitStrings = splitter.splitByDelimiter(text!!)

        var sum = 0
        for (splitString in splitStrings) {
            sum += StringValidator.convertValidateStringToNumber(splitString)
        }
        return sum
    }
}
