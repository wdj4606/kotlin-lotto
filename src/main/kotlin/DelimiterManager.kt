class DelimiterManager {
    var delimiters: MutableList<String> = mutableListOf(",", ":")

    fun extractDelimiter(text: String): String {
        val regex = Regex("//(.)\n(.*)")
        val matchResult = regex.find(text)

        return if (matchResult != null) {
            delimiters.add(matchResult.groupValues[1])
            matchResult.groupValues[2]
        } else {
            text
        }
    }
}
