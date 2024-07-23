import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach

class FormulaParserTest {
    private lateinit var parser: FormulaParser

    @BeforeEach
    fun setUp() {
        parser = FormulaParser();
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun oneNumber(text: String) {
        assertThat(parser.convertSingleInteger(text)).isSameAs(Integer.parseInt(text));
    }
}