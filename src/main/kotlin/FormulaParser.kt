class FormulaParser {
    fun convertSingleInteger(text: String): Int? {
        return try {
            text.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }
}