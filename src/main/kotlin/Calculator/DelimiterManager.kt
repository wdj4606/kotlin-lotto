package Calculator

class DelimiterManager {

    fun getTokens(text: String): List<String> {
        val result = Regex(CUSTOM_DELIMITER_PATTERN).find(text)
        return if (result != null) {
            val customDelimiter = result.groupValues[1]
            val delimiters = "$DEFAULT_DELIMITER|$customDelimiter"
            result.groupValues[2].split(Regex(delimiters))
        } else {
            text.split(Regex(DEFAULT_DELIMITER))
        }
    }

    companion object {
        private const val CUSTOM_DELIMITER_PATTERN = "//(.*)\n(.*)"
        private const val DEFAULT_DELIMITER = ",|:"
    }
}