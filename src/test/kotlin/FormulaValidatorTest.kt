import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.assertj.core.api.Assertions.assertThat

class FormulaValidatorTest {
    private lateinit var validator: FormulaValidator

    @BeforeEach
    fun setUp() {
        validator = FormulaValidator();
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        assertThat(validator.isNullOrEmptyOrBlank(text)).isTrue();
    }
}