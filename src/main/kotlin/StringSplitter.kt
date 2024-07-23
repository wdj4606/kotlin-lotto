class StringSplitter {
    private val delimiterManager: DelimiterManager = DelimiterManager()

    fun splitByDelimiter(text: String): List<String> {
        val restString = delimiterManager.extractDelimiter(text)

        val delimiters: MutableList<String> = mutableListOf()
        for (delimiter in delimiterManager.delimiters) {
            delimiters.add(Regex.escape(delimiter))
        }

        val combinedRegex = delimiters.joinToString(separator = "|") { it }
        return restString.split(combinedRegex.toRegex())
    }
}