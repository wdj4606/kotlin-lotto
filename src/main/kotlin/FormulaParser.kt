class FormulaParser {
    val delimiterManager: DelimiterManager = DelimiterManager()

    fun convertSingleInteger(text: String): Int? {
        return try {
            text.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }

    fun splitByDelimiter(text: String): List<String> {
        val delimiters: MutableList<String> = mutableListOf()
        for (delimiter in delimiterManager.delimiters) {
            delimiters.add(Regex.escape(delimiter))
        }

        val combinedRegex = delimiters.joinToString(separator = "|") { it }
        return text.split(combinedRegex.toRegex())
    }
}