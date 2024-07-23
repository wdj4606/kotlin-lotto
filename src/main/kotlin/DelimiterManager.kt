class DelimiterManager {
    var delimiters: MutableList<String> = mutableListOf(",", ":")

    fun extractDelimiter(text: String): String {
        val regex = Regex("//(.)\n(.*)")
        val matchResult = regex.find(text)

        return if (matchResult != null) {
            val delimiter = matchResult.groupValues[1]
            delimiters.add(delimiter)
            val remainingText = matchResult.groupValues[2]
            remainingText
        } else {
            text
        }
    }
}