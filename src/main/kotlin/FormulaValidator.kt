class FormulaValidator {
    fun isNullOrEmptyOrBlank(text: String?): Boolean {
        return text.isNullOrEmpty() || text.isBlank()
    }
}